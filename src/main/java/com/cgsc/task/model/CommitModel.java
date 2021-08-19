package com.cgsc.task.model;

import com.cgsc.task.entity.Commit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CommitModel extends AbstractModel<Commit> {
    private String url;
    private PersonCommitModel author;
    private PersonCommitModel committer;
    private String message;
    @JsonProperty("comment_count")
    private Integer commentCount;
    private VerificationModel verification;
}
