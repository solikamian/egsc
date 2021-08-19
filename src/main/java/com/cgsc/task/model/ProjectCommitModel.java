package com.cgsc.task.model;

import com.cgsc.task.entity.ProjectCommit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProjectCommitModel extends AbstractModel<ProjectCommit> {
    private String url;
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("html_rl")
    private String htmlUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    private CommitModel commit;
    private UserModel author;
    private UserModel committer;
    private ProjectModel project;
}
