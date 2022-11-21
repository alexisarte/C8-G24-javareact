package com.nocountry.No_Country.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BasicCartDTO {
    private List<ItemDTO> items;
    private Double totalAmount;
    private Long user;
}
