package edu.alexandra.pet.application.rest.request;

import edu.alexandra.pet.domain.PetActivity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class UpdatePetRequest {

    @NotBlank(message = "Activity is required")
    private final PetActivity activity;
}
