package com.cgsc.task.repository;

import com.cgsc.task.entity.ProjectCommit;

import java.util.Optional;

public interface ProjectCommitRepository extends AbstractRepository<ProjectCommit> {

    Optional<ProjectCommit> findByProjectNameAndSha(String projectName, String sha);
}
