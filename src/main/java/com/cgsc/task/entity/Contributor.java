package com.cgsc.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CONTRIBUTORS")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Contributor extends AbstractEntity {
    private Long total;
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Week> weeks;
}
