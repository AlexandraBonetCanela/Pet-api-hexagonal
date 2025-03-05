package edu.alexandra.pet.PetModule.infrastructure.repository;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pet")
@Table(name = "`pet`")
public class PetEntity {

    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "happiness_level", nullable = false)
    private int happinessLevel;

    @Column(name = "food_level", nullable = false)
    private int foodLevel;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "background_image", nullable = false)
    private String backgroundImage;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
