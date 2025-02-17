package edu.alexandra.pet.application.rest;

import edu.alexandra.pet.application.rest.request.CreatePetRequest;
import edu.alexandra.pet.domain.Pet;
import edu.alexandra.pet.domain.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/pet")
public class PetRESTController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody  CreatePetRequest createPetRequest) {

        log.info("Creating pet with name: {} for user {}", createPetRequest.getName(), createPetRequest.getUserId());

        Pet pet = petService.createPet(createPetRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pet.getId())
                .toUri();

        return ResponseEntity.created(uri).body(pet);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePet(@PathVariable String petId) {

        log.info("Deleting pet with id: {}", petId);

        petService.deletePet(petId);

        return ResponseEntity.noContent().build();
    }
}
