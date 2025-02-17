package edu.alexandra.pet.infraestructure.repository;

import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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