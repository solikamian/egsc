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
@Table(name = "WEEKS")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Week extends AbstractEntity {
    private Long startOfWeek;
    private Long numberOfAddition;
    private Long numberOfDeletion;
    private Long numberOfCommit;
}
