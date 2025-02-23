package edu.alexandra.pet.application.rest.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public final class LoginRequest {

    @NotBlank(message = "Username is required")
    private final String username;

    @NotBlank(message = "Password is required")
    private final String password;

}
