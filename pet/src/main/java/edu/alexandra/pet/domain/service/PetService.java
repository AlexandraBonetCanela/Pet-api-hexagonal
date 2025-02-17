package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.CreatePetRequest;
import edu.alexandra.pet.domain.Pet;

public interface PetService {

    Pet createPet(CreatePetRequest createPetRequest);

    void deletePet(String petId);
}
