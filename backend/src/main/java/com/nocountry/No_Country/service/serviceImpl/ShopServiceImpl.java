package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicShopDTO;
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

    public BasicShopDTO getShopById(Long shopId){
        Shop shop = shopRepository.findById(shopId).orElseThrow(
                ()-> new RuntimeException("Shop not found"));
        return shopMapper.shopEntity2BasicDTO(shop);
    }




}
