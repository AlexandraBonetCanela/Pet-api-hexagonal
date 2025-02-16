package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.CreatePetRequest;
import edu.alexandra.pet.domain.Pet;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PetServiceImpl implements PetService {

    @Override
    public Pet createPet(CreatePetRequest createPetRequest) {

        // Create pet
        Pet pet = Pet.builder()
                .id(UUID.randomUUID().toString())
                .name(createPetRequest.getName())
                .type(createPetRequest.getType())
                .build();

        // Add pet to User Pets collection


        // Return pet
        return pet;
    }
}
