package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.LoginRequest;
import edu.alexandra.pet.application.rest.request.RegisterRequest;
import edu.alexandra.pet.application.rest.response.AuthResponse;
import edu.alexandra.pet.domain.Role;
import edu.alexandra.pet.domain.User;
import edu.alexandra.pet.domain.repository.UserRepository;
import edu.alexandra.pet.infraestructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user = userRepository.findByUsername(loginRequest.getUsername());
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {

        User user = new User(
                UUID.randomUUID().toString(),
                registerRequest.getUsername(),
                passwordEncoder.encode(registerRequest.getPassword()),
                Role.USER,
                new ArrayList<>());

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
