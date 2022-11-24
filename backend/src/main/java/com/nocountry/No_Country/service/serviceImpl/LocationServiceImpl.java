package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicLocationDTO;
import com.nocountry.No_Country.dtos.LocationDTO;
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



    public LocationDTO createLocation(LocationDTO dto){
        Location location = locationMapper.locationDTO2Entity(dto);
        Location locationSaved = locationRepository.save(location);
        return locationMapper.locationEntity2DTO(locationSaved);
    }

    public LocationDTO updateLocation(LocationDTO dto){
        Location location = locationMapper.locationDTO2Entity(dto);
        location.setLocation_id(dto.getLocation_id());
        Location locationSaved = locationRepository.save(location);
        return locationMapper.locationEntity2DTO(locationSaved);
    }

    public String deleteLocation(Long locationId){
        Location location = locationRepository.findById(locationId).orElseThrow(
                ()-> new RuntimeException("Location not found"));

        locationRepository.delete(location);
        return("Location "+ location.getCity() + " has been deleted");
    }
    public BasicLocationDTO getLocationById(Long locationId){
        Location location = locationRepository.findById(locationId).orElseThrow(
                ()-> new RuntimeException("Location not found"));
        return locationMapper.locationEntity2BasicDTO(location);
    }

}
