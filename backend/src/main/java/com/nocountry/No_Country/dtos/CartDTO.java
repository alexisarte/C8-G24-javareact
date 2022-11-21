package com.nocountry.No_Country.dtos;

import com.nocountry.No_Country.entity.Item;
import com.nocountry.No_Country.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartDTO {

    private Long id;

    private List<ItemDTO> items;

    private LocalDateTime localDateTime;

    private Double totalAmount;

    private Long user;
}
