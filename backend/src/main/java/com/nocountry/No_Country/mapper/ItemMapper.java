package com.nocountry.No_Country.mapper;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.CartResumeDTO;
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
        dto.setAnimal(item.getAnimal());
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
        item.setAnimal(dto.getAnimal());
        return item;
    }

    public BasicItemDTO itemEntity2BasicDTO(Item item){
        BasicItemDTO basicItemDTO = new BasicItemDTO();
        basicItemDTO.setImageUrl(item.getImageUrl());
        basicItemDTO.setName(item.getName());
        basicItemDTO.setPrice(item.getPrice());
        return basicItemDTO;
    }

    public List<BasicItemDTO> itemEntityList2BasicDTOList(List<Item> items){

        List<BasicItemDTO> basicItems = new ArrayList<>();

        for(Item item : items){
            basicItems.add(this.itemEntity2BasicDTO(item));
        }
        return basicItems;

    }

    public CartResumeDTO item2CartResume(Item item){
        CartResumeDTO cartResumeDTO = new CartResumeDTO();
        cartResumeDTO.setName(item.getName());
        return cartResumeDTO;
    }

    public List<CartResumeDTO> itemList2Resume(List<Item> items){
        List<CartResumeDTO> cartResumeDTOS = new ArrayList<>();
        for(Item item: items){
            cartResumeDTOS.add(this.item2CartResume(item));
        }
        return cartResumeDTOS;
    }
}
