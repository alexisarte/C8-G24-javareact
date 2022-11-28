package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.BasicShopDTO;
import com.nocountry.No_Country.dtos.ShopDTO;
import com.nocountry.No_Country.entity.CategoryEnum;
import com.nocountry.No_Country.entity.Item;
import com.nocountry.No_Country.entity.Shop;
import com.nocountry.No_Country.mapper.ItemMapper;
import com.nocountry.No_Country.mapper.ShopMapper;
import com.nocountry.No_Country.repository.ItemRepository;
import com.nocountry.No_Country.repository.ShopRepository;
import com.nocountry.No_Country.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ItemRepository itemRepository;
    private final ShopMapper shopMapper;

    private final ItemMapper itemMapper;
    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ItemRepository itemRepository, ShopMapper shopMapper, ItemMapper itemMapper) {
        this.shopRepository = shopRepository;
        this.itemRepository = itemRepository;
        this.shopMapper = shopMapper;
        this.itemMapper = itemMapper;
    }

    public ShopDTO addItem2Shop(Long shopId, Long itemId){

        Shop shop = shopRepository.findById(shopId).orElseThrow(
                ()-> new RuntimeException("Can't add item. Shop not found"));

        Item item = itemRepository.findById(itemId).orElseThrow(
                ()-> new RuntimeException("Item not found"));

        shop.addItem(item);
        shopRepository.save(shop);

        return shopMapper.shopEntity2DTO(shop);
    }

    public ShopDTO createShop(ShopDTO dto){
        Shop shop = shopMapper.shopDTO2Entity(dto);
        Shop shopSaved = shopRepository.save(shop);
        return shopMapper.shopEntity2DTO(shopSaved);

    }

    public ShopDTO updateShop(ShopDTO dto){
        Shop shop = shopMapper.shopDTO2Entity(dto);
        shop.setId(dto.getId());
        Shop shopUpdated = shopRepository.save(shop);
        return shopMapper.shopEntity2DTO(shopUpdated);
    }

    public String deleteShop(Long shopId){
        Shop shop = shopRepository.findById(shopId).orElseThrow(
                ()-> new RuntimeException("Shop not found"));

        shopRepository.delete(shop);

        return("Shop " + shop.getName() +" has been deleted");
    }

    public List<BasicItemDTO> deleteOneItemFromShop(Long shopId, Long itemId){

        Shop shop = shopRepository.findById(shopId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        List<Item> shopItems = shop.getShopItems();

        for(Item item :shopItems){
            if (Objects.equals(item.getId(), itemId)){
                shopItems.remove(item);
                break;
            }
        }
        shopRepository.save(shop);
        return itemMapper.itemEntityList2BasicDTOList(shopItems);
    }

    public BasicShopDTO getShopById(Long shopId){
        Shop shop = shopRepository.findById(shopId).orElseThrow(
                ()-> new RuntimeException("Shop not found"));
        return shopMapper.shopEntity2BasicDTO(shop);
    }

    public List<BasicItemDTO> getShopItemsByCategory(Long shopId, CategoryEnum category){


        List<Item> itemsByCategory = new ArrayList<>();

        Shop shop = shopRepository.findById(shopId).orElseThrow(
                ()-> new RuntimeException("Shop not found"));

        List<Item> shopItems = shop.getShopItems();

        for(Item item : shopItems){
            if(item.getCategory() == category){
                itemsByCategory.add(item);
            }
        }

        return itemMapper.itemEntityList2BasicDTOList(itemsByCategory);

    }


}
