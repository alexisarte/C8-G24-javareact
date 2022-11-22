package com.nocountry.No_Country.mapper;

import com.nocountry.No_Country.dtos.ShopDTO;
import com.nocountry.No_Country.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopMapper {
    @Autowired
    private ItemMapper itemMapper;

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
}
