package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.RegistrationRequest;
import edu.alexandra.pet.application.rest.response.RegistrationResponse;
import edu.alexandra.pet.domain.Pet;

public interface UserService {

    RegistrationResponse register(RegistrationRequest request);

    void addPet(String userId, Pet pet);

//    void login();

//    void logout();

//    void delete();
}
