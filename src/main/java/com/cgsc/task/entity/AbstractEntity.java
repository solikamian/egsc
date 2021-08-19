package com.cgsc.task.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Builder.Default
    @Column(nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @NotNull
    @Builder.Default
    @Column(nullable = false)
    private LocalDateTime lastUpdateDate = LocalDateTime.now();

    @PreUpdate
    private void updateLastUpdateTime() {
        setLastUpdateDate(LocalDateTime.now());
    }

}
