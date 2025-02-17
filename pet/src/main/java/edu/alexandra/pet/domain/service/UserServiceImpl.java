package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.RegistrationRequest;
import edu.alexandra.pet.application.rest.response.RegistrationResponse;
import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.User;
import edu.alexandra.pet.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        return null;
    }

    @Override
    public Pet addPet(String userId, Pet pet) {

        return userRepository.addPet(userId, pet);
    }
}
