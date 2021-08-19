package com.cgsc.task.service;

import com.cgsc.task.endpoint.GithubEndpoint;
import com.cgsc.task.endpoint.response.SearchRepositoryResponse;
import com.cgsc.task.entity.Project;
import com.cgsc.task.mapper.AbstractMapper;
import com.cgsc.task.mapper.ProjectMapper;
import com.cgsc.task.model.ProjectModel;
import com.cgsc.task.repository.AbstractRepository;
import com.cgsc.task.repository.ProjectRepository;
import com.cgsc.task.rest.model.SearchModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService extends AbstractService<Project, ProjectModel> {
    private static final String NOT_EXISTS_REPOSITORY = "not exists repository ";

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final GithubEndpoint githubEndpoint;
    private final UserService userService;

    public ProjectService(ProjectRepository projectRepository,
                          ProjectMapper projectMapper,
                          GithubEndpoint githubEndpoint,
                          UserService userService) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.githubEndpoint = githubEndpoint;
        this.userService = userService;
    }

    @Transactional
    public List<ProjectModel> getProjects(SearchModel searchModel) {

        List<ProjectModel> projectModels = new ArrayList<>();
        githubEndpoint.getRepository(searchModel).ifPresent(searchRepositoryResponse ->
                searchRepositoryResponse.getItems().forEach(projectModel ->
                        projectModels.add(save(projectModel))));

        return projectModels;
    }

    @Transactional
    public ProjectModel save(ProjectModel model) {
        Project project = persist(model);

        return findOneMapper(project);
    }

    private Project persist(ProjectModel model) {

        Project project = Optional.ofNullable(model.getGithubId())
                .flatMap(projectRepository::findByGithubId)
                .orElseGet(() -> projectMapper.toEntity(model));
        project.setOwner(userService.save(model.getOwner()));
        return projectRepository.save(project);
    }

    @Transactional
    public Project getByName(String owner, String repo) {

        return projectRepository.findByName(repo)
                .orElseGet(() -> {
                    ProjectModel projectFromEndpoint = getProjectFromEndpoint(owner + "/" + repo);
                    return persist(projectFromEndpoint);
                });
    }

    private ProjectModel getProjectFromEndpoint(String name) {

        SearchModel searchModel = SearchModel.builder().projectName(name).build();
        SearchRepositoryResponse searchRepositoryResponse = githubEndpoint.getRepository(searchModel).orElseThrow(() -> {
            throw new IllegalArgumentException(NOT_EXISTS_REPOSITORY + name);
        });
        return searchRepositoryResponse.getItems()
                .stream()
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(NOT_EXISTS_REPOSITORY + name);
                });

    }

    @Override
    AbstractRepository<Project> getRepository() {
        return projectRepository;
    }

    @Override
    AbstractMapper<Project, ProjectModel> getMapper() {
        return projectMapper;
    }
}
