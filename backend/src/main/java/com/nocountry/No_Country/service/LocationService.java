package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.BasicLocationDTO;
import com.nocountry.No_Country.dtos.LocationDTO;
import com.nocountry.No_Country.entity.AnimalEnum;
import com.nocountry.No_Country.entity.CategoryEnum;

import java.util.List;

public interface LocationService {

    LocationDTO createLocation(LocationDTO dto);
    LocationDTO updateLocation(LocationDTO dto);
    String deleteLocation(Long locationId);
    BasicLocationDTO getLocationById(Long locationId);

    List<BasicItemDTO> getLocationItemsByCategoryOrAnimal(Long locationId,
                                                          AnimalEnum animal,
                                                          CategoryEnum categoryEnum);

}
