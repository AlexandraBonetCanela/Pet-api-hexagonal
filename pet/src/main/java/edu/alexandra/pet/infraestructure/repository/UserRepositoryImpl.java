package edu.alexandra.pet.infraestructure.repository;

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
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User save(User user) {
        return userMySQLRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userMySQLRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
