package com.nocountry.No_Country.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShopDTO {

    private Long id;

    private String name;

    private Long phoneNumber;

    private String email;

    private String password;

    private Long locationId;

    private String imageUrl;

}
