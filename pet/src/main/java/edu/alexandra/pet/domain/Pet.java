package edu.alexandra.pet.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
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

    private User owner;

    @Builder.Default
    private LocalDateTime lastUpdated = LocalDateTime.now();

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
            updateTimestamp();
            log.info("⏳ Pet '{}' stats auto-updated. New happinessLevel: {}, foodLevel: {}", name, happinessLevel, foodLevel);
        }
    }

    private void updateTimestamp() {
        this.lastUpdated = LocalDateTime.now();
        log.debug("📌 lastUpdated timestamp updated for pet '{}': {}", name, lastUpdated);
    }

}
