package edu.alexandra.pet.PetModule.domain.service;

import edu.alexandra.pet.PetModule.application.request.CreatePetRequest;
import edu.alexandra.pet.PetModule.application.request.UpdatePetRequest;
import edu.alexandra.pet.PetModule.domain.model.Pet;

import java.util.List;

public interface PetService {

    Pet createPet(CreatePetRequest createPetRequest);

    void deletePet(String petId);

    List<Pet> getPets(String userId);

    Pet updatePet(String petId, UpdatePetRequest updatePetRequest);

    List<Pet> getAllPets();

    Pet updatePetBackground(String petId, String newPetBackground);
}
