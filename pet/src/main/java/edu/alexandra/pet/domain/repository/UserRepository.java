package edu.alexandra.pet.domain.repository;

import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.User;

public interface UserRepository {

    User findById(String id);

    Pet addPet(String userId, Pet pet);
}
