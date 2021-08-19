package com.cgsc.task.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchModel {

    private Boolean publicProject;
    private String projectName;
    private String language;

    @Max(value = 100)
    private Integer perPage = 30;
    private Integer page = 1;
    private String order;
    private String sort;
}
