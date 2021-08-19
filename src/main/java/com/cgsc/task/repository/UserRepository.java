package com.cgsc.task.repository;

import com.cgsc.task.entity.User;

import java.util.Optional;

public interface UserRepository extends AbstractRepository<User> {

    Optional<User> findByGithubId(Long githubId);
}
