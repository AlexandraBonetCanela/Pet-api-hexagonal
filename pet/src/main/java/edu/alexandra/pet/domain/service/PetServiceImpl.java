package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.CreatePetRequest;
import edu.alexandra.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PetServiceImpl implements PetService {

    private final UserService userService;

    @Override
    public Pet createPet(CreatePetRequest createPetRequest) {

        // Create pet
        Pet pet = Pet.builder()
                .id(UUID.randomUUID().toString())
                .name(createPetRequest.getName())
                .type(createPetRequest.getType())
                .build();

        // Add pet to User Pets collection
        userService.addPet(createPetRequest.getUserId(), pet);

        // Return pet
        return pet;
    }
}
