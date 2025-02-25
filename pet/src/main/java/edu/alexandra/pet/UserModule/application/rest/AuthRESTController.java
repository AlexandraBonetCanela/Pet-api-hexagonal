package edu.alexandra.pet.UserModule.application.rest;

import edu.alexandra.pet.UserModule.application.request.LoginRequest;
import edu.alexandra.pet.UserModule.application.request.RegisterRequest;
import edu.alexandra.pet.UserModule.application.response.AuthResponse;
import edu.alexandra.pet.UserModule.domain.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/auth")
public class AuthRESTController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {

        log.info("Registering user with username: {}", registerRequest.getUsername());

        AuthResponse response = authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {

        log.info("Logging in user with username: {}", loginRequest.getUsername());
        //    userService.login();
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/logout")
    public String logout() {

        log.info("Logging out user");
        //    userService.logout();
        return "logout from public endpoint";
    }
}
