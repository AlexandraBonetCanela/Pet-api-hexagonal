package edu.alexandra.pet.PetModule.application;

import edu.alexandra.pet.PetModule.application.request.CreatePetRequest;
import edu.alexandra.pet.PetModule.application.request.UpdatePetRequest;
import edu.alexandra.pet.PetModule.domain.model.Pet;
import edu.alexandra.pet.PetModule.domain.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.security.access.prepost.PreAuthorize;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/pet")
public class PetRESTController {

    private final PetService petService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
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

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{userId}")
    public ResponseEntity<List<Pet>> getPets(@PathVariable String userId) {

        log.info("Getting pets for user with id: {}", userId);

        List<Pet> pets = petService.getPets(userId);

        return ResponseEntity.ok().body(pets);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/{petId}")
    public ResponseEntity<Pet> updatePet(@PathVariable String petId, @RequestBody UpdatePetRequest updatePetRequest) {

        log.info("Updating pet with id: {}", petId);

        Pet pet = petService.updatePet(petId, updatePetRequest);

        return ResponseEntity.ok().body(pet);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable String petId) {

        log.info("Deleting pet with id: {}", petId);

        petService.deletePet(petId);

        return ResponseEntity.noContent().build();
    }
}
