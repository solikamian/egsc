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
@Table(name = "VERIFICATIONS")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Verification extends AbstractEntity{
    private boolean verified;
    private String reason;
    private String signature;
    private String payload;
}
