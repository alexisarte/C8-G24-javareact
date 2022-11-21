package com.nocountry.No_Country.dtos;

import com.nocountry.No_Country.entity.CategoryEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemDTO {

    private Long id;
    private String name;
    private Double price;
    private Long stock;
    private CategoryEnum category;
    private String imageUrl;

}
