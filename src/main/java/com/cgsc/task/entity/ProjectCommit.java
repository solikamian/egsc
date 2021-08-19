package com.cgsc.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROJECT_COMMITS")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ProjectCommit extends AbstractEntity {
    private String url;
    private String sha;
    private String nodeId;
    private String htmlUrl;
    private String commentsUrl;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Commit commit;
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
    @ManyToOne(fetch = FetchType.LAZY)
    private User committer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
}
