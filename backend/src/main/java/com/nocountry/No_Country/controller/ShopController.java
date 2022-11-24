package com.nocountry.No_Country.controller;

import com.nocountry.No_Country.dtos.BasicShopDTO;
import com.nocountry.No_Country.dtos.ItemDTO;
import com.nocountry.No_Country.dtos.ShopDTO;
import com.nocountry.No_Country.service.ItemService;
import com.nocountry.No_Country.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;
    private final ItemService itemService;

    @Autowired
    public ShopController(ShopService shopService, ItemService itemService) {
        this.shopService = shopService;
        this.itemService = itemService;
    }

    //TODO Realizar primeros test para comprobar que la relaciones funcionan entre si.

    //TODO Comparar costos entre productos de una misma ciudad (Ale)

    //TODO crear entidad transaccion (Monto total, items, costo envio, direccion shop, direccion usuario)

    //TODO Resolver suma total carrito

    //TODO Resolver precio para cada item segun shop.

    //TODO Resolver Stock de tienda

    //TODO Ver bug de que se eliminan todos los productos con un mismo Id, en lugar de un producto a la vez

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

    @PostMapping
        public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO dto){
        return ResponseEntity.ok().body(shopService.createShop(dto));
    }

    @DeleteMapping("/delete/{shopId}")
        public ResponseEntity<String> deleteShop(@PathVariable Long shopId){
        return ResponseEntity.ok().body(shopService.deleteShop(shopId));
    }

    @PostMapping("item/create")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO dto){
        return ResponseEntity.ok().body(itemService.createItem(dto));
    }

}
