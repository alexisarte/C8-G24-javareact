package com.nocountry.No_Country.controller;

import com.nocountry.No_Country.dtos.ShopDTO;
import com.nocountry.No_Country.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;
    //TODO Realizar primeros test para comprobar que la relaciones funcionan entre si.

    //TODO Comparar costos entre productos de una misma ciudad (Ale)

    //TODO CRUD usuarios

    //TODO CRUD item (Leandro)

    //TODO CRUD shop (Leandro)

    //TODO CRUD location

    //TODO login

    //TODO CORS protocol.

    //TODO Crear DTOS en base a necesidades para evitar información no util.

    //TODO Comparar costos entre productos de una misma ciudad

    //TODO Ver bug de que se eliminan todos los productos con un mismo Id, en lugar de un producto a la vez

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
}
