package edu.alexandra.pet.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private String id;
    private String username;
    private String password;
    private List<Pet> pets;

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }
}
