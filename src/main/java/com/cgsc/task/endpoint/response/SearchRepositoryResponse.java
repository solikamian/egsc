package com.cgsc.task.endpoint.response;

import com.cgsc.task.model.ProjectModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRepositoryResponse {

    @JsonProperty("total_count")
    private Long totalCount;
    @JsonProperty("incomplete_results")
    private boolean incompleteResults;
    private List<ProjectModel> items;

}
