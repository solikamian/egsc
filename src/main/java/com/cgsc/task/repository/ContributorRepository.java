package com.cgsc.task.repository;

import com.cgsc.task.entity.Contributor;

import java.util.List;

public interface ContributorRepository extends AbstractRepository<Contributor> {

    List<Contributor> findByProjectNameAndAuthorLogin(String projectName, String login);
}
