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

    //TODO CRUD location (Lean)

    //TODO Resolver suma total carrito

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
}
