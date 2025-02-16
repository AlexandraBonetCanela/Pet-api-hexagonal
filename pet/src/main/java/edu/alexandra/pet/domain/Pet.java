package edu.alexandra.pet.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@EqualsAndHashCode
@AllArgsConstructor
public class Pet {

    private String id;
    private String name;
    private String type;

    @Min(0) @Max(5)
    @Builder.Default
    private int happinessLevel = 5;

    @Min(0) @Max(5)
    @Builder.Default
    private int foodLevel = 5;
}
