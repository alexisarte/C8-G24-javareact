package com.nocountry.No_Country.controller;

import com.nocountry.No_Country.dtos.*;
import com.nocountry.No_Country.entity.CategoryEnum;
import com.nocountry.No_Country.service.ItemService;
import com.nocountry.No_Country.service.LocationService;
import com.nocountry.No_Country.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;
    private final ItemService itemService;
    @Autowired
    private LocationService locationService;

    @Autowired
    public ShopController(ShopService shopService, ItemService itemService) {
        this.shopService = shopService;
        this.itemService = itemService;
    }

    //TODO crear entidad transaccion (Monto total, items, costo envio, direccion shop, direccion usuario)

    //TODO Resolver precio para cada item segun shop.

    //---------------------------------------------------------------------------------//

    //TODO documentar

    //TODO Implementar roles

    //TODO CRUD final de usuarios con roles y Auth.

    //TODO login

    //TODO CORS protocol.

    //TODO Crear DTOS en base a necesidades para evitar información no util.

    @PostMapping("/add/{shopId}/{itemId}")
    public ResponseEntity<ShopDTO> addItem2Shop(@PathVariable Long itemId,
                                                @PathVariable Long shopId){
        return ResponseEntity.ok().body(shopService.addItem2Shop(shopId,itemId));
    }

    @DeleteMapping("/delete/{shopId}/{itemId}")
        public ResponseEntity<ShopDTO> deleteItemFromShop(@PathVariable Long itemId,
                                                         @PathVariable Long shopId){
            return ResponseEntity.ok().body(shopService.removeItemFromShop(shopId,itemId));
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<BasicShopDTO> getShopById(@PathVariable Long shopId){

        return ResponseEntity.ok().body(shopService.getShopById(shopId));
    }

    @PostMapping("/create")
    public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO dto){
        ShopDTO shopCreated = shopService.createShop(dto);
        return new ResponseEntity<>(shopCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{shopId}")
        public ResponseEntity<String> deleteShop(@PathVariable Long shopId){
        return ResponseEntity.ok().body(shopService.deleteShop(shopId));
    }

    @PostMapping("item/create")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO dto){
        return ResponseEntity.ok().body(itemService.createItem(dto));
    }

    @PostMapping("/location/create")
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO dto){

        LocationDTO location = locationService.createLocation(dto);
        return new ResponseEntity<>(location,HttpStatus.CREATED);

    }

    @GetMapping("{shopId}/get/{category}")
    public ResponseEntity<List<BasicItemDTO>> filterShopItemsByCategory(@PathVariable Long shopId,
                                                                        @PathVariable CategoryEnum category){
        List<BasicItemDTO> shopItemsByCategory = shopService.getShopItemsByCategory(shopId,category);

        return new ResponseEntity<>(shopItemsByCategory, HttpStatus.OK);
    }

}
