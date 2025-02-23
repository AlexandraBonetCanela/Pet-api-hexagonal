package edu.alexandra.pet.domain.repository;

import edu.alexandra.pet.domain.User;

public interface UserRepository {

    User findById(String id);

    User save(User user);

    User findByUsername(String username);
}
