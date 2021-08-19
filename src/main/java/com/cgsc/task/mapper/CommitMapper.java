package com.cgsc.task.mapper;

import com.cgsc.task.entity.Commit;
import com.cgsc.task.model.CommitModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommitMapper extends AbstractMapper<Commit, CommitModel> {

}
