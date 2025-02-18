package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.CreatePetRequest;
import edu.alexandra.pet.application.rest.request.UpdatePetRequest;
import edu.alexandra.pet.domain.Pet;

import java.util.List;

public interface PetService {

    Pet createPet(CreatePetRequest createPetRequest);

    void deletePet(String petId);

    List<Pet> getPets(String userId);

    Pet updatePet(String petId, UpdatePetRequest updatePetRequest);
}
