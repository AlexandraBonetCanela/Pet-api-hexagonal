package edu.alexandra.pet.PetModule.domain.service;

import edu.alexandra.pet.PetModule.application.request.CreatePetRequest;
import edu.alexandra.pet.PetModule.application.request.UpdatePetRequest;
import edu.alexandra.pet.PetModule.domain.model.Pet;
import edu.alexandra.pet.PetModule.domain.model.PetState;
import edu.alexandra.pet.PetModule.domain.port.PetRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
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

        List<Pet> pets = petRepository.getPets(userId);

        pets.forEach(this::updateStats);

        return pets;
    }

    @Override
    public Pet updatePet(String petId, UpdatePetRequest updatePetRequest) {

        Pet pet = petRepository.getPet(petId);

        switch (updatePetRequest.getActivity()) {
            case FEED:
                feed(pet);
                break;
            case PLAY:
                play(pet);
                break;
            case SLEEP:
                sleep(pet);
                break;
        }

        return petRepository.updatePet(pet);
    }

    @Override
    public List<Pet> getAllPets() {

        return petRepository.getAllPets();
    }

    @Override
    public Pet updatePetBackground(String petId, String newPetBackground) {

        Pet pet = petRepository.getPet(petId);

        if (newPetBackground == null || newPetBackground.isEmpty()) {
            throw new IllegalArgumentException("Background image cannot be null or empty");
        }

        pet.setBackgroundImage(newPetBackground);

        return petRepository.updatePet(pet);
    }

    private void feed(Pet pet) {
        pet.setFoodLevel(Math.min(5, pet.getFoodLevel() + 1));
        pet.setHappinessLevel(Math.min(5, pet.getHappinessLevel() + 1));
        updateTimestamp(pet);
        log.info("Pet {} has been fed", pet.getName());
    }

    private void play(Pet pet) {
        pet.setHappinessLevel( Math.min(5, pet.getHappinessLevel() + 1));
        pet.setFoodLevel( Math.max(0, pet.getFoodLevel() - 1));
        updateTimestamp(pet);
        log.info("Pet {} has played", pet.getName());
    }

    private void sleep(Pet pet) {
        pet.setHappinessLevel(Math.max(0, pet.getHappinessLevel() - 1));
        pet.setFoodLevel(Math.max(0, pet.getFoodLevel() - 1));
        updateTimestamp(pet);
        log.info("Pet {} has slept", pet.getName());
    }

    public void updateStats(Pet pet) {
        LocalDateTime now = LocalDateTime.now();
        long minutesPassed = java.time.Duration.between(pet.getLastUpdated(), now).toMinutes();

        if (minutesPassed >= 10) {
            pet.setHappinessLevel(Math.max(0, pet.getHappinessLevel() - 1)) ;
            pet.setFoodLevel(Math.max(0, pet.getFoodLevel() - 1));
            pet.setState(PetState.SLEEPING);
            updateTimestamp(pet);
            log.info("⏳ Pet '{}' stats auto-updated. New happinessLevel: {}, foodLevel: {}", pet.getName(), pet.getHappinessLevel(), pet.getFoodLevel());
        }
    }

    private void updateTimestamp(Pet pet) {
        pet.setLastUpdated(LocalDateTime.now());
        log.debug("📌 lastUpdated timestamp updated for pet '{}': {}", pet.getName(), pet.getLastUpdated());
    }
}
