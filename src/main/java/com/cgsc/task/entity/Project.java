package com.cgsc.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROJECTS")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Project extends AbstractEntity {

    private Long githubId;
    private String nodeId;
    private String name;
    private String fullName;
    private boolean privateValue;
    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;
    private String htmlUrl;
    private String description;
    private boolean fork;
    private String url;
    private String forksUrl;
    private String keysUrl;
    private String collaboratorsUrl;
    private String teamsUrl;
    private String hooksUrl;
    private String issueEventsUrl;
    private String eventsUrl;
    private String assigneesUrl;
    private String branchesUrl;
    private String tagsUrl;
    private String blobsUrl;
    private String gitTagsUrl;
    private String gitRefsUrl;
    private String treesUrl;
    private String statusesUrl;
    private String languagesUrl;
    private String stargazersUrl;
    private String contributorsUrl;
    private String subscribersUrl;
    private String subscriptionUrl;
    private String commitsUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime pushedAt;
    private String homepage;
    private Integer size;
    private Integer stargazersCount;
    private Integer watchersCount;
    private String language;
    private Integer forksCount;
    private Integer openIssuesCount;
    private String masterBranch;
    private String defaultBranch;
    private Integer score;
    private String archiveUrl;
    private String commentsUrl;
    private String compareUrl;
    private String deploymentsUrl;
    private String downloadsUrl;
    private String gitCommitsUrl;
    private String gitUrl;
    private String issueCommentUrl;
    private String issuesUrl;
    private String labelsUrl;
    private String mergesUrl;
    private String milestonesUrl;
    private String notificationsUrl;
    private String pullsUrl;
    private String releasesUrl;
    private String sshUrl;
    private String cloneUrl;
    private String mirrorUrl;
    private String svnUrl;
    private Integer forks;
    private Integer openIssues;
    private Integer watchers;
    private boolean hasIssues;
    private boolean hasProjects;
    private boolean hasPages;
    private boolean hasWiki;
    private boolean hasDownloads;
    private boolean archived;
    private boolean disabled;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private License license;

}
