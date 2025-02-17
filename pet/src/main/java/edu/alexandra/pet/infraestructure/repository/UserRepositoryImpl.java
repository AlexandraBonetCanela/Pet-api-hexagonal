package edu.alexandra.pet.infraestructure.repository;

import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.User;
import edu.alexandra.pet.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class UserRepositoryImpl implements UserRepository {

    private final UserMySQLRepository userMySQLRepository;

    @Override
    public User findById(String id) {
        return userMySQLRepository.findById(id)
                .map(this::toDomain)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public Pet addPet(String userId, Pet pet) throws RuntimeException {
        return userMySQLRepository.findById(userId)
                .map(userEntity -> {
                    userEntity.getPets().add(
                            PetEntity.builder()
                                    .id(pet.getId())
                                    .name(pet.getName())
                                    .type(pet.getType())
                                    .foodLevel(pet.getFoodLevel())
                                    .happinessLevel(pet.getHappinessLevel())
                                    .userId(userId)
                                    .lastUpdated(pet.getLastUpdated())
                                    .build()
                    );
                    return userMySQLRepository.save(userEntity);
                })
                .map(savedUserEntity -> pet)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                null // Pets are handled separately
        );
    }
}
