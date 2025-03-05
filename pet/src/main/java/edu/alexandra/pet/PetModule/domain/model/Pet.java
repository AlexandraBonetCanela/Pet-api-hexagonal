package edu.alexandra.pet.PetModule.domain.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Getter
@ToString
@EqualsAndHashCode
public class Pet {

    public Pet(String name, PetType type) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.happinessLevel = 3;
        this.foodLevel = 3;
        this.state = PetState.AWAKE;
        this.backgroundImage = "PLAIN";
        this.lastUpdated = LocalDateTime.now();
    }

    public Pet(String id, String name, PetType type, int happinessLevel, int foodLevel, PetState state, String backgroundImage, LocalDateTime lastUpdated) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.happinessLevel = happinessLevel;
        this.foodLevel = foodLevel;
        this.state = state;
        this.backgroundImage = backgroundImage;
        this.lastUpdated = lastUpdated;
    }

    private final String id;
    private final String name;
    private final PetType type;

    @Min(0) @Max(5)
    @Setter
    private int happinessLevel;

    @Min(0) @Max(5)
    @Setter
    private int foodLevel;

    @Setter
    private PetState state;

    @Setter
    private String backgroundImage;

    @Setter
    private LocalDateTime lastUpdated;

}
