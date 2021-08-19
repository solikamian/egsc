package com.cgsc.task.mapper;

import com.cgsc.task.entity.Contributor;
import com.cgsc.task.model.ContributorModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContributorMapper extends AbstractMapper<Contributor, ContributorModel> {

}
