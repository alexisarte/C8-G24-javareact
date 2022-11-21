package com.nocountry.No_Country.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasicShopDTO {
    private String name;
    private Long phoneNumber;
    private Long locationId;
    private String imageUrl;

}
