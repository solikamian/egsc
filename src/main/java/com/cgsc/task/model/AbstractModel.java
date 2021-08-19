package com.cgsc.task.model;

import com.cgsc.task.entity.AbstractEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AbstractModel<T extends AbstractEntity> {

}
