package com.cgsc.task.mapper;

import com.cgsc.task.entity.PersonCommit;
import com.cgsc.task.model.PersonCommitModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonCommitMapper extends AbstractMapper<PersonCommit, PersonCommitModel> {

}
