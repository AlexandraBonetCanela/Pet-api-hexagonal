package edu.alexandra.pet.PetModule.domain.service;

import edu.alexandra.pet.PetModule.application.request.CreatePetRequest;
import edu.alexandra.pet.PetModule.application.request.UpdatePetRequest;
import edu.alexandra.pet.PetModule.domain.model.Pet;
import edu.alexandra.pet.PetModule.domain.model.PetType;
import edu.alexandra.pet.PetModule.domain.port.PetRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PetServiceImpl implements PetService {

    private final PetRepositoryPort petRepository;

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
            case FEED:
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

    @Override
    public List<Pet> getAllPets() {

        return petRepository.getAllPets();
    }
}
