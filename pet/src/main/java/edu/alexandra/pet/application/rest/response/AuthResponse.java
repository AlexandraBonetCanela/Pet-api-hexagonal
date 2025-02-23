package edu.alexandra.pet.application.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public final class AuthResponse {

    private final String token;

}
