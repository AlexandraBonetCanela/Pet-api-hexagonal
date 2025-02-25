package edu.alexandra.pet.PetModule.infrastructure.repository;

import edu.alexandra.pet.PetModule.domain.model.Pet;
import edu.alexandra.pet.PetModule.domain.port.PetRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class PetRepositoryImpl implements PetRepositoryPort {

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