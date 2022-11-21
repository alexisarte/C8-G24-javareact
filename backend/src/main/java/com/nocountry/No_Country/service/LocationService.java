package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.BasicLocationDTO;
import com.nocountry.No_Country.dtos.UserDTO;

public interface LocationService {

    BasicLocationDTO getBasicLocationById(Long id);

}
