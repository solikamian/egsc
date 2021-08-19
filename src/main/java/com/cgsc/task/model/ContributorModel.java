package com.cgsc.task.model;

import com.cgsc.task.entity.Contributor;
import lombok.Data;

import java.util.List;

@Data
public class ContributorModel extends AbstractModel<Contributor> {
    private Long total;
    private UserModel author;
    private List<WeekModel> weeks;
    private ProjectModel project;
}
