package edu.alexandra.pet.PetModule.infrastructure.repository;

import edu.alexandra.pet.PetModule.domain.exception.DatabaseException;
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
        if(!petMySQLRepository.existsById(petId)) {
            throw new DatabaseException("Pet with ID " + petId + " not found");
        }
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
                .orElseThrow(() -> new DatabaseException("Pet not found"));
    }

    @Override
    public Pet createPet(Pet pet, String userId) {
        try {
            return PetMapper.toDomain(petMySQLRepository.save(PetMapper.toEntity(pet, userId)));
        } catch (Exception e ) {
            throw new DatabaseException("An unexpected error occurred while creating pet");
        }
    }

    @Override
    public Pet updatePet(Pet pet) {
        PetEntity entity = petMySQLRepository.findById(pet.getId())
                .orElseThrow(() -> new DatabaseException("Pet not found"));
        return PetMapper.toDomain(petMySQLRepository.save(PetMapper.toEntity(pet, entity.getUserId())));
    }

    @Override
    public List<Pet> getAllPets() {
        return petMySQLRepository.findAll()
                .stream()
                .map(PetMapper::toDomain)
                .toList();
    }
}