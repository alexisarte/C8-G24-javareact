package com.nocountry.No_Country.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasicItemDTO {
    private String name;
    private Double price;
    private Long stock;
    private String imageUrl;

}
