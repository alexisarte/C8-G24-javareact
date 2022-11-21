package com.nocountry.No_Country.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasicUserDTO {
    private String firstName;
    private String lastName;
    private LocationDTO locationId;
    private CartDTO cartDTO;
}
