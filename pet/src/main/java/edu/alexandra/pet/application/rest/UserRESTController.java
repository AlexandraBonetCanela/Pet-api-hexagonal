package edu.alexandra.pet.application.rest;

import edu.alexandra.pet.application.rest.request.RegistrationRequest;
import edu.alexandra.pet.application.rest.response.RegistrationResponse;
import edu.alexandra.pet.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/auth")
public class UserRESTController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(
            @Valid @RequestBody RegistrationRequest registrationRequest) {

        RegistrationResponse response = userService.register(registrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public void login() {
    //    userService.login();
    }

    @PostMapping("/logout")
    public void logout() {
    //    userService.logout();
    }

    @PostMapping("/delete")
    public void delete() {
     //   userService.delete();
    }
}
