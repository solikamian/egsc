package com.cgsc.task.mapper;

import com.cgsc.task.entity.License;
import com.cgsc.task.model.LicenseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LicenseMapper extends AbstractMapper<License, LicenseModel> {

}
