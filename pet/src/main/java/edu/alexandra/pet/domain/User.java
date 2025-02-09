package edu.alexandra.pet.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private String id;
    private String username;
    private String password;
}
