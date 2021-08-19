package com.cgsc.task.model;

import com.cgsc.task.entity.PersonCommit;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonCommitModel extends AbstractModel<PersonCommit> {
    private String name;
    private String email;
    private LocalDateTime date;
}
