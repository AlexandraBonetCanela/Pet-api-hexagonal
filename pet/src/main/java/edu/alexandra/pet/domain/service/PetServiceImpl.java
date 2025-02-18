package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.CreatePetRequest;
import edu.alexandra.pet.application.rest.request.UpdatePetRequest;
import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.PetActivity;
import edu.alexandra.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PetServiceImpl implements PetService {

    private final UserService userService;
    private final PetRepository petRepository;

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

    @Override
    public void deletePet(String petId) {
        petRepository.deletePet(petId);
    }

    @Override
    public List<Pet> getPets(String userId) {
        return petRepository.getPets(userId);
    }

    @Override
    public Pet updatePet(String petId, UpdatePetRequest updatePetRequest) {

        // Get pet
        Pet pet = petRepository.getPet(petId);

        // Update pet
        switch (updatePetRequest.getActivity()) {
            case EAT:
                pet.feed();
                break;
            case PLAY:
                pet.play();
                break;
            case SLEEP:
                pet.sleep();
                break;
        }

        // Save and return pet
        return petRepository.savePet(pet);
    }
}
