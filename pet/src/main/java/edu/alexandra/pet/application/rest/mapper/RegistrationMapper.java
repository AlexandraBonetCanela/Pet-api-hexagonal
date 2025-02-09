package edu.alexandra.pet.application.rest.mapper;

import edu.alexandra.pet.application.rest.request.RegistrationRequest;
import edu.alexandra.pet.application.rest.response.RegistrationResponse;
import edu.alexandra.pet.domain.User;

import java.util.UUID;

public class RegistrationMapper {

    public static User mapToDomain(RegistrationRequest dto) {
        return new User(UUID.randomUUID().toString(), dto.getUsername(), dto.getPassword());
    }

    public static RegistrationResponse mapToResponse(String message) {
        return new RegistrationResponse(message);
    }
}
