package com.cgsc.task.endpoint;

import com.cgsc.task.endpoint.response.SearchRepositoryResponse;
import com.cgsc.task.model.ContributorModel;
import com.cgsc.task.model.ProjectCommitModel;
import com.cgsc.task.rest.model.SearchModel;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;

@Slf4j
@Component
public class GithubEndpoint {

    private static final long SLOW_CALL_DURATION_THRESHOLD_IN_SECONDS = 5;

    private final GithubFeignClient githubFeignClient;

    private final CircuitBreaker getRepositoryCircuitBreaker;
    private final CircuitBreaker getUserCircuitBreaker;
    private final CircuitBreaker getRepositoryCommitCircuitBreaker;

    // TODO: 19.08.21 header set karde contributor

    public GithubEndpoint(GithubFeignClient githubFeignClient) {
        this.githubFeignClient = githubFeignClient;

        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.from(CircuitBreakerConfig.ofDefaults())
                .slowCallDurationThreshold(Duration.ofSeconds(SLOW_CALL_DURATION_THRESHOLD_IN_SECONDS))
                .build();

        getRepositoryCircuitBreaker = CircuitBreaker.of("repositoryCircuitBreaker", circuitBreakerConfig);
        getUserCircuitBreaker = CircuitBreaker.of("userCircuitBreaker", circuitBreakerConfig);
        getRepositoryCommitCircuitBreaker = CircuitBreaker.of("repositoryCommitCircuitBreaker", circuitBreakerConfig);
    }

    public Optional<SearchRepositoryResponse> getRepository(SearchModel searchModel) {

        Map<String, Object> parameters = getSearchMap(searchModel);

        CheckedFunction0<SearchRepositoryResponse> decorateCheckedSupplier = CircuitBreaker.decorateCheckedSupplier(getRepositoryCircuitBreaker,
                () -> githubFeignClient.getProjects(parameters));

        return Try.of(decorateCheckedSupplier)
                .map(Optional::of)
                .onFailure(e -> log.error("error in getting repository summary from github.", e))
                .getOrElse(Optional::empty);
    }

    public List<ContributorModel> getContributors(String owner, String repository) {

        CheckedFunction0<List<ContributorModel>> decorateCheckedSupplier = CircuitBreaker.decorateCheckedSupplier(getUserCircuitBreaker,
                () -> githubFeignClient.getContributors(owner, repository));

        return Try.of(decorateCheckedSupplier)
                .onFailure(e -> log.error("error in getting contributor with owner {} and repository {} from github.", owner, repository, e))
                .getOrElse(Collections::emptyList);
    }

    public List<ProjectCommitModel> getRepositoryCommit(String owner, String repository) {

        CheckedFunction0<List<ProjectCommitModel>> decorateCheckedSupplier = CircuitBreaker.decorateCheckedSupplier(getRepositoryCommitCircuitBreaker,
                () -> githubFeignClient.getCommits(owner, repository));

        return Try.of(decorateCheckedSupplier)
                .onFailure(e -> log.error("error in getting commits with owner {} and repository {} from github.", owner, repository, e))
                .getOrElse(Collections::emptyList);
    }


    private Map<String, Object> getSearchMap(SearchModel searchModel) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("q", createProjectQuery(searchModel));
        if(searchModel.getPage() != null)
            parameters.put("page", searchModel.getPage());
        if(searchModel.getPerPage() != null)
            parameters.put("per_page", searchModel.getPerPage());
        if(searchModel.getSort() != null)
            parameters.put("sort", searchModel.getSort());
        if(searchModel.getOrder() != null) {
            parameters.put("order", searchModel.getOrder());
        }
        return parameters;
    }

    private String createProjectQuery(SearchModel searchModel){
        StringBuilder searchQuery = new StringBuilder();
        if(searchModel.getPublicProject() != null && searchModel.getPublicProject().equals(true))
            searchQuery.append("is:public");
        if(searchModel.getLanguage() != null)
            searchQuery.append("+language:").append(searchModel.getLanguage());
        if(searchModel.getProjectName() != null)
            searchQuery.append("repo:").append(searchModel.getProjectName());
        return searchQuery.toString();
    }

}
