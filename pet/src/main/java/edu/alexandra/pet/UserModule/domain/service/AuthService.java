package edu.alexandra.pet.UserModule.domain.service;

import edu.alexandra.pet.UserModule.application.request.LoginRequest;
import edu.alexandra.pet.UserModule.application.request.RegisterRequest;
import edu.alexandra.pet.UserModule.application.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(RegisterRequest registerRequest);
}
