package com.cgsc.task.service;

import com.cgsc.task.endpoint.GithubEndpoint;
import com.cgsc.task.entity.ProjectCommit;
import com.cgsc.task.mapper.AbstractMapper;
import com.cgsc.task.mapper.ProjectCommitMapper;
import com.cgsc.task.model.ProjectCommitModel;
import com.cgsc.task.repository.AbstractRepository;
import com.cgsc.task.repository.ProjectCommitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProjectCommitService extends AbstractService<ProjectCommit, ProjectCommitModel> {

    private final ProjectCommitRepository projectCommitRepository;
    private final ProjectCommitMapper projectCommitMapper;
    private final GithubEndpoint githubEndpoint;
    private final ProjectService projectService;
    private final UserService userService;

    public ProjectCommitService(ProjectCommitRepository projectCommitRepository,
                                ProjectCommitMapper projectCommitMapper,
                                GithubEndpoint githubEndpoint,
                                ProjectService projectService,
                                UserService userService) {
        this.projectCommitRepository = projectCommitRepository;
        this.projectCommitMapper = projectCommitMapper;
        this.githubEndpoint = githubEndpoint;
        this.projectService = projectService;
        this.userService = userService;
    }

    @Transactional
    public List<ProjectCommitModel> getProjectCommit(String owner, String repo) {

        List<ProjectCommitModel> projectCommitModels = new ArrayList<>();
        githubEndpoint.getRepositoryCommit(owner, repo).forEach(projectCommitModel ->
                projectCommitModels.add(save(projectCommitModel, owner, repo)));

        return projectCommitModels;
    }

    public ProjectCommitModel save(ProjectCommitModel model, String owner, String repo) {

        ProjectCommit projectCommit = projectCommitMapper.toEntity(model);

        projectCommitRepository.findByProjectNameAndSha(repo, model.getSha())
                .ifPresent(findCommit -> projectCommit.setId(findCommit.getId()));

        projectCommit.setProject(projectService.getByName(owner, repo));
        projectCommit.setAuthor(userService.save(model.getAuthor()));
        projectCommit.setCommitter(userService.save(model.getCommitter()));
        return projectCommitMapper.toModel(projectCommitRepository.save(projectCommit));
    }

    @Override
    AbstractRepository<ProjectCommit> getRepository() {
        return projectCommitRepository;
    }

    @Override
    AbstractMapper<ProjectCommit, ProjectCommitModel> getMapper() {
        return projectCommitMapper;
    }
}
