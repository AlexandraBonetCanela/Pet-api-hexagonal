package edu.alexandra.pet.PetModule.infrastructure.repository;

import edu.alexandra.pet.PetModule.domain.model.Pet;
import edu.alexandra.pet.PetModule.domain.model.PetState;
import edu.alexandra.pet.PetModule.domain.model.PetType;

import java.util.ArrayList;
import java.util.List;

public class PetMapper {

    public static PetEntity toEntity(Pet pet, String userId) {

        return new PetEntity(
                pet.getId(),
                pet.getName(),
                pet.getType().toString(),
                pet.getHappinessLevel(),
                pet.getFoodLevel(),
                pet.getState().toString(),
                pet.getLastUpdated(),
                userId
        );
    }

    public static Pet toDomain(PetEntity entity) {

        return new Pet(
                entity.getId(),
                entity.getName(),
                PetType.valueOf(entity.getType()),
                entity.getHappinessLevel(),
                entity.getFoodLevel(),
                PetState.valueOf(entity.getState()),
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
