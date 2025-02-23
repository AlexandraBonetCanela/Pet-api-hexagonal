package edu.alexandra.pet.application.rest;

import edu.alexandra.pet.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/auth")
public class UserRESTController {

    private final UserService userService;



    @PostMapping("/delete")
    public void delete() {
     //   userService.delete();
    }
}
