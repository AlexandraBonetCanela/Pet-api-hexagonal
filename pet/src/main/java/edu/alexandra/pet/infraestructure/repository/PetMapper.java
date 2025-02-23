package edu.alexandra.pet.infraestructure.repository;

import edu.alexandra.pet.domain.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetMapper {

    public static PetEntity toEntity(Pet pet, String userId) {

        return new PetEntity(
                pet.getId(),
                pet.getName(),
                pet.getType(),
                pet.getHappinessLevel(),
                pet.getFoodLevel(),
                pet.getLastUpdated(),
                userId
        );
    }

    public static Pet toDomain(PetEntity entity) {

        return new Pet(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getHappinessLevel(),
                entity.getFoodLevel(),
                entity.getLastUpdated()
        );
    }

    public static List<PetEntity> toEntityList(List<Pet> pets, String userId) {

        List<PetEntity> petEntities = new ArrayList<>();
        for (Pet pet : pets) {
            petEntities.add(PetMapper.toEntity(pet, userId));
        }
        return petEntities;
    }
}
