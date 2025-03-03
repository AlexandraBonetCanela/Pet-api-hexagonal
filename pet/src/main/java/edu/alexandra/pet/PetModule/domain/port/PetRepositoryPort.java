package edu.alexandra.pet.PetModule.domain.port;

import edu.alexandra.pet.PetModule.domain.model.Pet;

import java.util.List;

public interface PetRepositoryPort {

    void deletePet(String petId);

    List<Pet> getPets(String userId);

    Pet getPet(String petId);

    Pet createPet(Pet pet, String userId);

    Pet updatePet(Pet pet);

    List<Pet> getAllPets();
}
