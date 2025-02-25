package edu.alexandra.pet.UserModule.infrastructure.repository;

import edu.alexandra.pet.UserModule.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMySQLRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
}
