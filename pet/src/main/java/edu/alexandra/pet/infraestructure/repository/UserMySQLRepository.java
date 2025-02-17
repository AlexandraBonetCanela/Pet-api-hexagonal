package edu.alexandra.pet.infraestructure.repository;

import edu.alexandra.pet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMySQLRepository extends JpaRepository<UserEntity, String> {

}
