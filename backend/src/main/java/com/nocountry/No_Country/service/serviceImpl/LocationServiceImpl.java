package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.BasicLocationDTO;
import com.nocountry.No_Country.dtos.LocationDTO;
import com.nocountry.No_Country.entity.*;
import com.nocountry.No_Country.mapper.ItemMapper;
import com.nocountry.No_Country.mapper.LocationMapper;
import com.nocountry.No_Country.repository.LocationRepository;
import com.nocountry.No_Country.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationMapper locationMapper;
    private final LocationRepository locationRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public LocationServiceImpl(LocationMapper locationMapper, LocationRepository locationRepository, ItemMapper itemMapper) {
        this.locationMapper = locationMapper;
        this.locationRepository = locationRepository;
        this.itemMapper = itemMapper;
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
                ()-> new RuntimeException("Wrong id, location doesn't exists"));

        locationRepository.delete(location);
        return("Location "+ location.getCity() + " has been deleted");
    }
    public BasicLocationDTO getLocationById(Long locationId){
        Location location = locationRepository.findById(locationId).orElseThrow(
                ()-> new RuntimeException("Location not found"));
        return locationMapper.locationEntity2BasicDTO(location);
    }

    public List<BasicItemDTO> getLocationItemsByCategoryOrAnimal(Long locationId,
                                                                 AnimalEnum animal,
                                                                 CategoryEnum categoryEnum){

        List<Item> itemsByFilter = new ArrayList<>();
        Location location = locationRepository.findById(locationId)
                .orElseThrow(
                    ()-> new RuntimeException("Location not found"));

        for(Shop shop : location.getShops()){
            for(Item item : shop.getShopItems()){
                if((item.getCategory() == categoryEnum) && (item.getAnimal() == animal)){
                    itemsByFilter.add(item);
                }
            }

        }
        return itemMapper.itemEntityList2BasicDTOList(itemsByFilter);
    }

}
