package com.cgsc.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LICENSES")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class License extends AbstractEntity {

    private String key;
    private String name;
    private String url;
    private String spdxId;
    private String nodeId;
    private String htmlUrl;
}
