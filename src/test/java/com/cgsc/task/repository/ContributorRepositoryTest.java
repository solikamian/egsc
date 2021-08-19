package com.cgsc.task.repository;

import com.cgsc.task.entity.Contributor;
import com.cgsc.task.entity.Project;
import com.cgsc.task.entity.User;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest(properties = {
        "spring.flyway.enabled=false",
        "spring.jpa.properties.hibernate.default_schema=",
        "spring.jpa.hibernate.ddl-auto=create-drop",
})
public class ContributorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContributorRepository contributorRepository;

    @Test
    void findByProjectNameAndAuthorLogin() {

        User author = User.builder()
                .login("foo@bar")
                .githubId(RandomUtils.nextLong())
                .build();

        Project project = Project.builder()
                .name("foo_project")
                .githubId(RandomUtils.nextLong())
                .build();

        Contributor contributor = Contributor.builder()
                .author(author)
                .project(project)
                .build();

        entityManager.persist(author);
        entityManager.persist(project);
        entityManager.persist(contributor);


        List<Contributor> contributors = contributorRepository
                .findByProjectNameAndAuthorLogin("foo_project", "foo@bar");


        assertThat(contributors.size())
                .isEqualTo(1);

        Contributor c = contributors.get(0);

        assertThat(c.getId()).isEqualTo(contributor.getId());

    }
}
