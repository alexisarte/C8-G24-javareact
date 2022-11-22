package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.ShopDTO;
import com.nocountry.No_Country.entity.Item;
import com.nocountry.No_Country.entity.Shop;
import com.nocountry.No_Country.mapper.ShopMapper;
import com.nocountry.No_Country.repository.ItemRepository;
import com.nocountry.No_Country.repository.ShopRepository;
import com.nocountry.No_Country.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ItemRepository itemRepository;
    private final ShopMapper shopMapper;
    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ItemRepository itemRepository, ShopMapper shopMapper) {
        this.shopRepository = shopRepository;
        this.itemRepository = itemRepository;
        this.shopMapper = shopMapper;
    }

    public ShopDTO addItem2Shop(Long shopId, Long itemId){

        Shop shop = shopRepository.findById(shopId).orElseThrow(
                ()-> new RuntimeException("Shop not found"));

        Item item = itemRepository.findById(itemId).orElseThrow(
                ()-> new RuntimeException("Item not found"));

        shop.addItem(item);
        shopRepository.save(shop);

        return shopMapper.shopEntity2DTO(shop);
    }

    public ShopDTO removeItemFromShop(Long itemId, Long shopId){

        Shop shop = shopRepository.findById(shopId).orElseThrow(()-> new RuntimeException("Shop not found"));

        shop.deleteItem(itemId);
        shopRepository.save(shop);
        return shopMapper.shopEntity2DTO(shop);
    }

}
