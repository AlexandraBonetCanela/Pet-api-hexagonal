package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

}
