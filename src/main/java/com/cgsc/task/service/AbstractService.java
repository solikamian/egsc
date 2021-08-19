package com.cgsc.task.service;


import com.cgsc.task.entity.AbstractEntity;
import com.cgsc.task.mapper.AbstractMapper;
import com.cgsc.task.model.AbstractModel;
import com.cgsc.task.repository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractService<T extends AbstractEntity, R extends AbstractModel<T>> {


    abstract AbstractRepository<T> getRepository();

    abstract AbstractMapper<T, R> getMapper();

    @Transactional(readOnly = true)
    public Page<R> findAll(Pageable pageable) {
        return getRepository().findAll(pageable)
                .map(this::findAllMapper);
    }

    @Transactional
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    R findAllMapper(T entity) {
        return getMapper().toModel(entity);
    }

    R findOneMapper(T entity) {
        return getMapper().toModel(entity);
    }
}
