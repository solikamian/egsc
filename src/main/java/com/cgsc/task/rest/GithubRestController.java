package com.cgsc.task.rest;

import com.cgsc.task.model.ContributorModel;
import com.cgsc.task.model.ProjectCommitModel;
import com.cgsc.task.model.ProjectModel;
import com.cgsc.task.rest.model.SearchModel;
import com.cgsc.task.service.ContributorService;
import com.cgsc.task.service.ProjectCommitService;
import com.cgsc.task.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search/")
public class GithubRestController {

    private final ProjectService projectService;
    private final ContributorService contributorService;
    private final ProjectCommitService projectCommitService;

    public GithubRestController(ProjectService projectService,
                                ContributorService contributorService,
                                ProjectCommitService projectCommitService) {
        this.projectService = projectService;
        this.contributorService = contributorService;
        this.projectCommitService = projectCommitService;
    }

    @GetMapping("projects")
    @Operation(summary = "Get all projects  by search model")
    public List<ProjectModel> getProjects(@Validated SearchModel searchModel) {
        return projectService.getProjects(searchModel);
    }

    @GetMapping("/repos/{owner}/{repo}/contributors")
    @Operation(summary = "Get all contributors for a  certain project")
    public List<ContributorModel> getContributors(@PathVariable("owner") String owner, @PathVariable("repo") String repo) {
        return contributorService.getContributors(owner, repo);
    }

    @GetMapping("/repos/{owner}/{repo}/commits")
    @Operation(summary = "Get all project commits for a certain project")
    public List<ProjectCommitModel> getProjectCommits(@PathVariable("owner") String owner, @PathVariable("repo") String repo) {
        return projectCommitService.getProjectCommit(owner, repo);
    }

}
