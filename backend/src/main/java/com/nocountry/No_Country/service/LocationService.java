package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.BasicLocationDTO;
import com.nocountry.No_Country.dtos.LocationDTO;

public interface LocationService {

    LocationDTO createLocation(LocationDTO dto);
    LocationDTO updateLocation(LocationDTO dto);
    String deleteLocation(Long locationId);
    BasicLocationDTO getLocationById(Long locationId);

}
