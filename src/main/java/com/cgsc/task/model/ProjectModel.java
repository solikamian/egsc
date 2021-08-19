package com.cgsc.task.model;

import com.cgsc.task.entity.Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectModel extends AbstractModel<Project> {

    @JsonProperty("id")
    private Long githubId;
    @JsonProperty("node_id")
    private String nodeId;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("private")
    private boolean privateValue;
    private UserModel owner;
    @JsonProperty("html_url")
    private String htmlUrl;
    private String description;
    private boolean fork;
    private String url;
    @JsonProperty("forks_url")
    private String forksUrl;
    @JsonProperty("keys_url")
    private String keysUrl;
    @JsonProperty("collaborators_url")
    private String collaboratorsUrl;
    @JsonProperty("teams_url")
    private String teamsUrl;
    @JsonProperty("hooks_url")
    private String hooksUrl;
    @JsonProperty("issue_events_url")
    private String issueEventsUrl;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("assignees_url")
    private String assigneesUrl;
    @JsonProperty("branches_url")
    private String branchesUrl;
    @JsonProperty("tags_url")
    private String tagsUrl;
    @JsonProperty("blobs_url")
    private String blobsUrl;
    @JsonProperty("git_tags_url")
    private String gitTagsUrl;
    @JsonProperty("git_refs_url")
    private String gitRefsUrl;
    @JsonProperty("trees_url")
    private String treesUrl;
    @JsonProperty("statuses_url")
    private String statusesUrl;
    @JsonProperty("languages_url")
    private String languagesUrl;
    @JsonProperty("stargazers_url")
    private String stargazersUrl;
    @JsonProperty("contributors_url")
    private String contributorsUrl;
    @JsonProperty("subscribers_url")
    private String subscribersUrl;
    @JsonProperty("subscription_url")
    private String subscriptionUrl;
    @JsonProperty("commits_url")
    private String commitsUrl;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    @JsonProperty("pushed_at")
    private LocalDateTime pushedAt;
    private String homepage;
    private Integer size;
    @JsonProperty("stargazers_count")
    private Integer stargazersCount;
    @JsonProperty("watchers_count")
    private Integer watchersCount;
    private String language;
    @JsonProperty("forks_count")
    private Integer forksCount;
    @JsonProperty("open_issues_count")
    private Integer openIssuesCount;
    @JsonProperty("master_branch")
    private String masterBranch;
    @JsonProperty("default_branch")
    private String defaultBranch;
    private Integer score;
    @JsonProperty("archive_url")
    private String archiveUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("compare_url")
    private String compareUrl;
    @JsonProperty("deployments_url")
    private String deploymentsUrl;
    @JsonProperty("downloads_url")
    private String downloadsUrl;
    @JsonProperty("git_commits_url")
    private String gitCommitsUrl;
    @JsonProperty("git_url")
    private String gitUrl;
    @JsonProperty("issue_comment_url")
    private String issueCommentUrl;
    @JsonProperty("issues_url")
    private String issuesUrl;
    @JsonProperty("labels_url")
    private String labelsUrl;
    @JsonProperty("merges_url")
    private String mergesUrl;
    @JsonProperty("milestones_url")
    private String milestonesUrl;
    @JsonProperty("notifications_url")
    private String notificationsUrl;
    @JsonProperty("pulls_url")
    private String pullsUrl;
    @JsonProperty("releases_url")
    private String releasesUrl;
    @JsonProperty("ssh_url")
    private String sshUrl;
    @JsonProperty("clone_url")
    private String cloneUrl;
    @JsonProperty("mirror_url")
    private String mirrorUrl;
    @JsonProperty("svn_url")
    private String svnUrl;
    private Integer forks;
    @JsonProperty("open_issues")
    private Integer openIssues;
    private Integer watchers;
    @JsonProperty("has_issues")
    private boolean hasIssues;
    @JsonProperty("has_projects")
    private boolean hasProjects;
    @JsonProperty("has_pages")
    private boolean hasPages;
    @JsonProperty("has_wiki")
    private boolean hasWiki;
    @JsonProperty("has_downloads")
    private boolean hasDownloads;
    private boolean archived;
    private boolean disabled;
    private LicenseModel license;

}
