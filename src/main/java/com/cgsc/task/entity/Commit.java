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
@Table(name = "COMMITS")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Commit extends AbstractEntity {
    private String url;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PersonCommit author;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PersonCommit committer;
    private String message;
    private Integer commentCount;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Verification verification;
}
