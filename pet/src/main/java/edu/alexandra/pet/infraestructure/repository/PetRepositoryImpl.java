package edu.alexandra.pet.infraestructure.repository;

import edu.alexandra.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class PetRepositoryImpl implements PetRepository {

    private final PetMySQLRepository petMySQLRepository;

    @Override
    public void deletePet(String petId) {
        petMySQLRepository.deleteById(petId);
    }
}