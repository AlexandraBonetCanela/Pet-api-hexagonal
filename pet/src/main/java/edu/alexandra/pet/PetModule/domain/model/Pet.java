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
        updateStats();
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

    public void feed() {
        this.foodLevel = Math.min(5, this.foodLevel + 1);
        this.happinessLevel = Math.min(5, this.happinessLevel + 1);
        updateTimestamp();
        log.info("Pet {} has been fed", this.name);
    }

    public void play() {
        this.happinessLevel = Math.min(5, this.happinessLevel + 1);
        this.foodLevel = Math.max(0, this.foodLevel - 1);
        updateTimestamp();
        log.info("Pet {} has played", this.name);
    }

    public void sleep() {
        this.happinessLevel = Math.max(0, this.happinessLevel - 1);
        this.foodLevel = Math.max(0, this.foodLevel - 1);
        updateTimestamp();
        log.info("Pet {} has slept", this.name);
    }

    public void updateStats() {
        LocalDateTime now = LocalDateTime.now();
        long minutesPassed = java.time.Duration.between(lastUpdated, now).toMinutes();

        if (minutesPassed >= 10) {
            this.happinessLevel = Math.max(0, this.happinessLevel - 1);
            this.foodLevel = Math.max(0, this.foodLevel - 1);
            this.state = PetState.SLEEPING;
            updateTimestamp();
            log.info("⏳ Pet '{}' stats auto-updated. New happinessLevel: {}, foodLevel: {}", name, happinessLevel, foodLevel);
        }
    }

    private void updateTimestamp() {
        this.lastUpdated = LocalDateTime.now();
        log.debug("📌 lastUpdated timestamp updated for pet '{}': {}", name, lastUpdated);
    }

}
