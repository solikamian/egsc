package com.cgsc.task.service;

import com.cgsc.task.endpoint.GithubEndpoint;
import com.cgsc.task.entity.Contributor;
import com.cgsc.task.mapper.AbstractMapper;
import com.cgsc.task.mapper.ContributorMapper;
import com.cgsc.task.model.ContributorModel;
import com.cgsc.task.repository.AbstractRepository;
import com.cgsc.task.repository.ContributorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContributorService extends AbstractService<Contributor, ContributorModel> {

    private final ContributorRepository contributorRepository;
    private final ContributorMapper contributorMapper;
    private final GithubEndpoint githubEndpoint;

    private final ProjectService projectService;
    private final UserService userService;

    public ContributorService(ContributorRepository contributorRepository,
                              ContributorMapper contributorMapper,
                              GithubEndpoint githubEndpoint,
                              ProjectService projectService,
                              UserService userService) {
        this.contributorRepository = contributorRepository;
        this.contributorMapper = contributorMapper;
        this.githubEndpoint = githubEndpoint;
        this.projectService = projectService;
        this.userService = userService;
    }

    @Transactional
    public List<ContributorModel> getContributors(String owner, String repo) {

        List<ContributorModel> contributorModels = new ArrayList<>();
        githubEndpoint.getContributors(owner, repo).forEach(contributorModel -> contributorModels.add(save(contributorModel, owner, repo)));

        return contributorModels;
    }

    private ContributorModel save(ContributorModel model, String owner, String repo) {

        if (model.getAuthor() == null)
            throw new IllegalArgumentException("author can not be null");

        List<Contributor> contributors = contributorRepository.findByProjectNameAndAuthorLogin
                (repo, model.getAuthor().getLogin());

        Contributor contributor = contributorMapper.toEntity(model);

        contributors.stream().findFirst().ifPresent(findContributor -> contributor.setId(findContributor.getId()));

        contributor.setProject(projectService.getByName(owner, repo));
        contributor.setAuthor(userService.save(model.getAuthor()));
        return contributorMapper.toModel(contributorRepository.save(contributor));
    }

    @Override
    AbstractRepository<Contributor> getRepository() {
        return contributorRepository;
    }

    @Override
    AbstractMapper<Contributor, ContributorModel> getMapper() {
        return contributorMapper;
    }
}
