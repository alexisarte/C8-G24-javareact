package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.ItemDTO;
import com.nocountry.No_Country.entity.AnimalEnum;
import com.nocountry.No_Country.entity.CategoryEnum;
import com.nocountry.No_Country.entity.Item;
import com.nocountry.No_Country.mapper.ItemMapper;
import com.nocountry.No_Country.repository.ItemRepository;
import com.nocountry.No_Country.service.ItemService;
import com.nocountry.No_Country.utils.CreatePage;
import com.nocountry.No_Country.utils.FinalPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.stream.Collectors;

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

    public FinalPage getItemsByFilters(int page,
                                       String name,
                                       AnimalEnum animal,
                                       CategoryEnum categoryEnum){

        Pageable pageable = PageRequest.of(page-1,3) ;
        CreatePage createPage = new CreatePage();

        if(name != null && (animal != null || categoryEnum != null)){
            Page <Item> itemsByFilters = itemRepository.getItemsByNameAndCategoryOrAnimal(
                    name, categoryEnum, animal, pageable);

            createPage.paginateResult(itemsByFilters).loadList(itemsByFilters.getContent().stream()
                    .map(itemMapper::itemEntity2DTO).collect(Collectors.toList()));
        }
        return createPage.build();

    }


}
