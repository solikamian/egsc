package com.cgsc.task.mapper;

import com.cgsc.task.entity.Project;
import com.cgsc.task.model.ProjectModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends AbstractMapper<Project, ProjectModel> {

}
