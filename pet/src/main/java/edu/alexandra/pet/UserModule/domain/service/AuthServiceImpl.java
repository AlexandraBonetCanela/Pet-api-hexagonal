package edu.alexandra.pet.UserModule.domain.service;

import edu.alexandra.pet.UserModule.application.request.LoginRequest;
import edu.alexandra.pet.UserModule.application.request.RegisterRequest;
import edu.alexandra.pet.UserModule.application.response.AuthResponse;
import edu.alexandra.pet.UserModule.domain.model.User;
import edu.alexandra.pet.UserModule.domain.port.UserRepositoryPort;
import edu.alexandra.pet.SecurityModule.domain.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepositoryPort userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user = userRepository.findByUsername(loginRequest.getUsername());
        String token = jwtService.getToken(user);

        return new AuthResponse(token);

    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {

        User user = new User(
                        registerRequest.getUsername(),
                        passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);
        String token = jwtService.getToken(user);

        return new AuthResponse(token);

    }
}
