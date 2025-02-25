package edu.alexandra.pet.PetModule.application.request;

import edu.alexandra.pet.PetModule.domain.model.PetActivity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class UpdatePetRequest {

    @NotBlank(message = "Activity is required")
    private final PetActivity activity;
}
