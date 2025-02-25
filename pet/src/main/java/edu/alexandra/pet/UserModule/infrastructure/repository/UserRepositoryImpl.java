package edu.alexandra.pet.UserModule.infrastructure.repository;

import edu.alexandra.pet.UserModule.domain.model.User;
import edu.alexandra.pet.UserModule.domain.port.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class UserRepositoryImpl implements UserRepositoryPort {

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
