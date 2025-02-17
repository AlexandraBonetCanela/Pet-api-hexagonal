package edu.alexandra.pet.domain.repository;

import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.User;

public interface UserRepository {

    User findById(String id);

    User addPet(User user, Pet pet);
}
