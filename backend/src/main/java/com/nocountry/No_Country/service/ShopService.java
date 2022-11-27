package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.BasicShopDTO;
import com.nocountry.No_Country.dtos.ShopDTO;
import com.nocountry.No_Country.entity.CategoryEnum;

import java.util.List;

public interface ShopService {
    ShopDTO removeItemFromShop(Long itemId, Long shopId);
    ShopDTO addItem2Shop(Long shopId, Long itemId);
    ShopDTO createShop(ShopDTO dto);
    ShopDTO updateShop(ShopDTO dto);
    String deleteShop(Long shopId);
    BasicShopDTO getShopById(Long shopId);
    List<BasicItemDTO> getShopItemsByCategory(Long shopId, CategoryEnum category);
}
