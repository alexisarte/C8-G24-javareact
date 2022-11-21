package com.nocountry.No_Country.dtos;

import com.nocountry.No_Country.entity.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LocationDTO {

    private Long location_id;

    private String streetName;

    private String city;

    private String state;

    private List<ShopDTO> shopList;
    private List<UserDTO> userList;
}
