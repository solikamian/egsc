package com.cgsc.task.endpoint.response;

import com.cgsc.task.model.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchUsersResponse {

    @JsonProperty("total_count")
    private Long totalCount;
    @JsonProperty("incomplete_results")
    private boolean incompleteResults;
    private List<UserModel> users;

}
