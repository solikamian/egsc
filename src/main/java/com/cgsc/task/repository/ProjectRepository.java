package com.cgsc.task.repository;

import com.cgsc.task.entity.Project;

import java.util.Optional;

public interface ProjectRepository extends AbstractRepository<Project> {

    Optional<Project> findByName(String name);
    Optional<Project> findByGithubId(Long id);

}
