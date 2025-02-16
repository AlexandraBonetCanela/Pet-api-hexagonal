package edu.alexandra.pet.domain;

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
    private int happinessLevel;
    private int hungerLevel;
}
