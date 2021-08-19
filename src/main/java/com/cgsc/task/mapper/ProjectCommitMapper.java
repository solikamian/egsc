package com.cgsc.task.mapper;

import com.cgsc.task.entity.ProjectCommit;
import com.cgsc.task.model.ProjectCommitModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectCommitMapper extends AbstractMapper<ProjectCommit, ProjectCommitModel> {

}
