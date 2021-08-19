package com.cgsc.task.mapper;

import com.cgsc.task.entity.Week;
import com.cgsc.task.model.WeekModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WeekMapper extends AbstractMapper<Week, WeekModel> {

}
