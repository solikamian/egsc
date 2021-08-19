package com.cgsc.task.model;

import com.cgsc.task.entity.Week;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeekModel extends AbstractModel<Week> {
    @JsonProperty("w")
    private Long startOfWeek;
    @JsonProperty("a")
    private Long numberOfAddition;
    @JsonProperty("d")
    private Long numberOfDeletion;
    @JsonProperty("c")
    private Long numberOfCommit;
}
