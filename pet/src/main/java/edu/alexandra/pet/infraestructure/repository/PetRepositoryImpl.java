package edu.alexandra.pet.infraestructure.repository;

import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class PetRepositoryImpl implements PetRepository {

    private final PetMySQLRepository petMySQLRepository;

    @Override
    public void deletePet(String petId) {
        petMySQLRepository.deleteById(petId);
    }

    @Override
    public List<Pet> getPets(String userId) {
        return petMySQLRepository.findByUserId(userId)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Pet getPet(String petId) {
        return petMySQLRepository.findById(petId)
                .map(this::toDomain)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @Override
    public Pet savePet(Pet pet) {
        return toDomain(petMySQLRepository.save(toEntity(pet)));
    }

    private PetEntity toEntity(Pet pet) {
        return PetEntity.builder()
                .id(pet.getId())
                .name(pet.getName())
                .type(pet.getType())
                .foodLevel(pet.getFoodLevel())
                .happinessLevel(pet.getHappinessLevel())
                .userId(petMySQLRepository.findById(pet.getId()).orElseThrow(() -> new RuntimeException("User not found")).getUserId())
                .lastUpdated(pet.getLastUpdated())
                .build();
    }

    private Pet toDomain(PetEntity entity) {
        return new Pet(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getHappinessLevel(),
                entity.getFoodLevel(),
                entity.getLastUpdated()
        );
    }
}