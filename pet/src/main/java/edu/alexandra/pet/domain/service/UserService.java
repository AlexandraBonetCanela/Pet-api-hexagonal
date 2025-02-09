package edu.alexandra.pet.domain.service;

import edu.alexandra.pet.application.rest.request.RegistrationRequest;
import edu.alexandra.pet.application.rest.response.RegistrationResponse;

public interface UserService {

    RegistrationResponse register(RegistrationRequest request);

//    void login();

//    void logout();

//    void delete();
}
