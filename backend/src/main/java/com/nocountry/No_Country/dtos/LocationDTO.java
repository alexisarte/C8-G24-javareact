package com.nocountry.No_Country.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LocationDTO {

    private Long location_id;

    private String city;

    private String state;

    private List<ShopDTO> shopList;
    private List<UserDTO> userList;
}
