package edu.alexandra.pet.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetMySQLRepository extends JpaRepository<PetEntity, String> {

    List<PetEntity> findByUserId(String userId);
}
