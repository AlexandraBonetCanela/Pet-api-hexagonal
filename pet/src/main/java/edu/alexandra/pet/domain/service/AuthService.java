package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.LoginRequest;
import edu.alexandra.pet.application.rest.request.RegisterRequest;
import edu.alexandra.pet.application.rest.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(RegisterRequest registerRequest);
}
