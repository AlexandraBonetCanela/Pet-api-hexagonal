package edu.alexandra.pet.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMySQLRepository extends JpaRepository<UserEntity, String> {

}
