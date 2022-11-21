package com.nocountry.No_Country.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BasicLocationDTO {
    private List<ShopDTO> shopList;
    private String city;
    private String state;
}
