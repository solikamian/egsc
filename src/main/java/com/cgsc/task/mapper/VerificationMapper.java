package com.cgsc.task.mapper;

import com.cgsc.task.entity.Verification;
import com.cgsc.task.model.VerificationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VerificationMapper extends AbstractMapper<Verification, VerificationModel> {

}
