package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.ItemDTO;

public interface ItemService {

    ItemDTO createItem(ItemDTO dto);
    ItemDTO updateItem(ItemDTO dto);
    String deleteItem(Long itemId);
    BasicItemDTO getItemById(Long itemId);
}
