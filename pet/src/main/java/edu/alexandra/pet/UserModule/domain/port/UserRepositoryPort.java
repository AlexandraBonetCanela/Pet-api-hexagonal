package edu.alexandra.pet.UserModule.domain.port;

import edu.alexandra.pet.UserModule.domain.model.User;

public interface UserRepositoryPort {

    User findById(String id);

    User save(User user);

    User findByUsername(String username);
}
