package com.cgsc.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSON_COMMITS")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class PersonCommit extends AbstractEntity{
    private String name;
    private String email;
    private LocalDateTime date;
}
