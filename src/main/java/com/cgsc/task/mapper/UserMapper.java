package com.cgsc.task.mapper;

import com.cgsc.task.entity.User;
import com.cgsc.task.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<User, UserModel> {

}
