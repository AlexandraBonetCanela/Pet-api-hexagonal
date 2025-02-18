package edu.alexandra.pet.domain.repository;

import edu.alexandra.pet.domain.Pet;

import java.util.List;

public interface PetRepository  {

    void deletePet(String petId);

    List<Pet> getPets(String userId);

    Pet getPet(String petId);

    Pet savePet(Pet pet);
}
