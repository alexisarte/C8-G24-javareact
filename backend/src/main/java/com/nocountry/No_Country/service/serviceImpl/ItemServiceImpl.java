package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.ItemDTO;
import com.nocountry.No_Country.entity.Item;
import com.nocountry.No_Country.mapper.ItemMapper;
import com.nocountry.No_Country.repository.ItemRepository;
import com.nocountry.No_Country.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDTO createItem(ItemDTO dto) {
        Item item = itemMapper.itemDTO2Entity(dto);
        Item itemSaved = itemRepository.save(item);
        return itemMapper.itemEntity2DTO(itemSaved);

    }

    public ItemDTO updateItem(ItemDTO dto) {
        Item item = itemMapper.itemDTO2Entity(dto);
        item.setId(dto.getId());
        Item itemSaved = itemRepository.save(item);
        return itemMapper.itemEntity2DTO(itemSaved);
    }

    public String deleteItem(Long itemId){
        Item item = itemRepository.findById(itemId).orElseThrow(
                ()-> new RuntimeException("Item not found with id: "+itemId));

        itemRepository.delete(item);

        return("Item " + item.getName() + " has been deleted.");
    }
    public BasicItemDTO getItemById(Long itemId){
        Item item = itemRepository.findById(itemId).orElseThrow(
                ()-> new RuntimeException("Item not found with id: "+itemId));
        return itemMapper.itemEntity2BasicDTO(item);
    }


}
