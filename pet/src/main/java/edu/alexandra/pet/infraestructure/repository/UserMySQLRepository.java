package edu.alexandra.pet.infraestructure.repository;

import edu.alexandra.pet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMySQLRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
}
