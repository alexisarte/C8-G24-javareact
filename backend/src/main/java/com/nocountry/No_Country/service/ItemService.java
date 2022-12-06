package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.ItemDTO;
import com.nocountry.No_Country.entity.AnimalEnum;
import com.nocountry.No_Country.entity.CategoryEnum;
import com.nocountry.No_Country.utils.FinalPage;

public interface ItemService {

    ItemDTO createItem(ItemDTO dto);
    ItemDTO updateItem(ItemDTO dto);
    String deleteItem(Long itemId);
    BasicItemDTO getItemById(Long itemId);

    FinalPage getItemsByFilters(int page,
                                String name,
                                AnimalEnum animal,
                                CategoryEnum categoryEnum);
}
