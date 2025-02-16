package edu.alexandra.pet.application.rest;

import edu.alexandra.pet.application.rest.request.CreatePetRequest;
import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/pet")
public class PetRESTController {

    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> createPet(CreatePetRequest createPetRequest) {

        log.info("Creating pet with name: {} for user {}", createPetRequest.getName(), createPetRequest.getUserId());

        Pet pet = petService.createPet(createPetRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pet.getId())
                .toUri();

        return ResponseEntity.created(uri).body(pet);
    }
}
