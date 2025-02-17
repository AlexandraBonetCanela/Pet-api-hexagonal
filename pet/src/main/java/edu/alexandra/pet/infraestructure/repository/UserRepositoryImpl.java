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
    public User addPet(User user, Pet pet) {
        return null;
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
