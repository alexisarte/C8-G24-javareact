package com.nocountry.No_Country.mapper;

import com.nocountry.No_Country.dtos.BasicShopDTO;
import com.nocountry.No_Country.dtos.ShopDTO;
import com.nocountry.No_Country.entity.Shop;
import com.nocountry.No_Country.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopMapper {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private LocationRepository locationRepository;

    public ShopDTO shopEntity2DTO(Shop shop){
        ShopDTO dto = new ShopDTO();
        dto.setEmail(shop.getEmail());
        dto.setId(shop.getId());
        dto.setName(shop.getName());
        dto.setLocationId(shop.getLocation().getLocation_id());
        dto.setPhoneNumber(shop.getPhoneNumber());
        dto.setImageUrl(shop.getImageUrl());
        dto.setShopItems(itemMapper.itemEntityList2DTOList(shop.getShopItems()));
        return dto;
    }

    public List<ShopDTO> shopEntityList2DTOList(List<Shop> shops){
        List<ShopDTO> shopDTOS = new ArrayList<>();
        for(Shop shop : shops){
            shopDTOS.add(this.shopEntity2DTO(shop));
        }
        return shopDTOS;
    }

    public Shop shopDTO2Entity(ShopDTO dto){
        Shop shop = new Shop();
        shop.setEmail(dto.getEmail());
        shop.setImageUrl(dto.getImageUrl());
        shop.setName(dto.getName());
        shop.setPhoneNumber(dto.getPhoneNumber());
        shop.setLocation(locationRepository.findById(dto.getLocationId())
                .orElseThrow(
                        ()->new RuntimeException("Location not found")));
        shop.setOpeningHours(dto.getOpeningHours());
        return shop;
    }

    public BasicShopDTO shopEntity2BasicDTO(Shop shop){
        BasicShopDTO basicShopDTO = new BasicShopDTO();
        basicShopDTO.setName(shop.getName());
        basicShopDTO.setLocationId(shop.getLocation().getLocation_id());
        basicShopDTO.setPhoneNumber(shop.getPhoneNumber());
        basicShopDTO.setOpeningHours(shop.getOpeningHours());
        return basicShopDTO;
    }

    public List<BasicShopDTO> shopEntityList2BasicDTOList(List<Shop> shops){
        List<BasicShopDTO> shopsDTOs = new ArrayList<>();

        for(Shop shop : shops){
            shopsDTOs.add(this.shopEntity2BasicDTO(shop));
        }
        return shopsDTOs;

    }
}
