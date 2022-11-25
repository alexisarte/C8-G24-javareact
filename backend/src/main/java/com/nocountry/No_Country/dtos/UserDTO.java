package com.nocountry.No_Country.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private LocationDTO locationId;

    private CartDTO cartDTO;

    private String streetName;


    public UserDTO(Long id, String password, Long id1, String email, String firstName, String lastName, Long locationId) {
    }
}
