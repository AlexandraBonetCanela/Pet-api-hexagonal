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
                .map(PetMapper::toDomain)
                .toList();
    }

    @Override
    public Pet getPet(String petId) {
        return petMySQLRepository.findById(petId)
                .map(PetMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @Override
    public Pet createPet(Pet pet, String userId) {
        return PetMapper.toDomain(petMySQLRepository.save(PetMapper.toEntity(pet, userId)));
    }

    @Override
    public Pet updatePet(Pet pet) {
        PetEntity entity = petMySQLRepository.findById(pet.getId())
                .orElseThrow(() -> new RuntimeException("Pet not found"));
        return PetMapper.toDomain(petMySQLRepository.save(PetMapper.toEntity(pet, entity.getUserId())));
    }
}