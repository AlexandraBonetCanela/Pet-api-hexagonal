package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.CreatePetRequest;
import edu.alexandra.pet.application.rest.request.UpdatePetRequest;
import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public Pet createPet(CreatePetRequest createPetRequest) {

        Pet pet = new Pet(createPetRequest.getName(), createPetRequest.getType());
        petRepository.createPet(pet, createPetRequest.getUserId());

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

        Pet pet = petRepository.getPet(petId);

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

        return petRepository.updatePet(pet);
    }
}
