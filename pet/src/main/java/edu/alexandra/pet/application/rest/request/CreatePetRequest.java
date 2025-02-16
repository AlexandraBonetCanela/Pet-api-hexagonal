package edu.alexandra.pet.application.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePetRequest {

    private String userId;
    private String name;
    private String type;
}
