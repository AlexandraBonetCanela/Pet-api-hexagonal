package edu.alexandra.pet.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Pet {

    private String id;
    private String name;
    private String type;
    private int happinessLevel;
    private int hungerLevel;
}
