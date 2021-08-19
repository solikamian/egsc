package com.cgsc.task.mapper;


import com.cgsc.task.model.AbstractModel;
import com.cgsc.task.entity.AbstractEntity;

public interface AbstractMapper<T extends AbstractEntity, R extends AbstractModel<T>> {

    T toEntity(R model);
    R toModel(T entity);

}
