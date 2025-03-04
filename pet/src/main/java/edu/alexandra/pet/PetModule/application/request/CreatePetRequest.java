package edu.alexandra.pet.PetModule.application.request;

import edu.alexandra.pet.PetModule.domain.model.PetType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class CreatePetRequest {

    @NotBlank(message = "UserId is required")
    private final String userId;

    @NotBlank(message = "Name is required")
    private final String name;

    @NotBlank(message = "Type is required")
    private final PetType type;
}
