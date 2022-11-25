package com.nocountry.No_Country.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BasicShopDTO {
    private String name;
    private Long phoneNumber;
    private String city;
    private String streetName;
    private String imageUrl;
    private String openingHours;
    private List<BasicItemDTO> shopItems;

}
