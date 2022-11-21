package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicLocationDTO;
import com.nocountry.No_Country.entity.Location;
import com.nocountry.No_Country.mapper.LocationMapper;
import com.nocountry.No_Country.repository.LocationRepository;
import com.nocountry.No_Country.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationMapper locationMapper;
    private final LocationRepository locationRepository;
    @Autowired
    public LocationServiceImpl(LocationMapper locationMapper, LocationRepository locationRepository) {
        this.locationMapper = locationMapper;
        this.locationRepository = locationRepository;
    }


    public BasicLocationDTO getBasicLocationById(Long id){
        Location location = locationRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Location not found"));

        return locationMapper.locationEntity2BasicDTO(location);
    }

}
