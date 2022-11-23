package com.nocountry.No_Country.mapper;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.ItemDTO;
import com.nocountry.No_Country.entity.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemMapper {

    public ItemDTO itemEntity2DTO(Item item){
        ItemDTO dto = new ItemDTO();
        dto.setCategory(item.getCategory());
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setPrice(item.getPrice());
        dto.setImageUrl(item.getImageUrl());
        return dto;
    }

    public List<ItemDTO> itemEntityList2DTOList(List<Item> items){
        List<ItemDTO> itemsDtos = new ArrayList<>();
        for(Item item : items){
            itemsDtos.add(this.itemEntity2DTO(item));
        }
        return itemsDtos;
    }

    public Item itemDTO2Entity(ItemDTO dto){
        Item item = new Item();
        item.setName(dto.getName());
        item.setCategory(dto.getCategory());
        item.setImageUrl(dto.getImageUrl());
        item.setPrice(dto.getPrice());
        return item;
    }

    public BasicItemDTO itemEntity2BasicDTO(Item item){
        BasicItemDTO basicItemDTO = new BasicItemDTO();
        basicItemDTO.setImageUrl(item.getImageUrl());
        basicItemDTO.setName(item.getName());
        basicItemDTO.setPrice(item.getPrice());
        basicItemDTO.setStock(item.getStock());
        return basicItemDTO;
    }
}
