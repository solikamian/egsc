package com.cgsc.task.endpoint;

import com.cgsc.task.endpoint.response.SearchRepositoryResponse;
import com.cgsc.task.model.ContributorModel;
import com.cgsc.task.model.ProjectCommitModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(name = "github", url = "${github.url}")
public interface GithubFeignClient {

    @GetMapping("/search/repositories")
    SearchRepositoryResponse getProjects(@SpringQueryMap Map<String, Object> queryParameters);

    @GetMapping("/repos/{owner}/{repo}/stats/contributors")
    List<ContributorModel> getContributors(@PathVariable String owner, @PathVariable String repo);

    @GetMapping("/repos/{owner}/{repo}/commits")
    List<ProjectCommitModel> getCommits(@PathVariable String owner, @PathVariable String repo);

}
