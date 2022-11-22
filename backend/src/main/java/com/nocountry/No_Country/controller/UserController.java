package com.nocountry.No_Country.controller;

import com.nocountry.No_Country.dtos.BasicLocationDTO;
import com.nocountry.No_Country.dtos.CartDTO;
import com.nocountry.No_Country.dtos.UserDTO;
import com.nocountry.No_Country.service.CartService;
import com.nocountry.No_Country.service.LocationService;
import com.nocountry.No_Country.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final LocationService locationService;
    private final CartService cartService;
    @Autowired
    public UserController(UserService userService, LocationService locationService, CartService cartService) {

        this.userService = userService;
        this.locationService = locationService;
        this.cartService = cartService;
    }


    //Funcion creada solo a fines de test :)
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = this.userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<BasicLocationDTO> getLocationById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.locationService.getBasicLocationById(id));
    }

    @PostMapping("{userId}/add/{itemId}")
        public ResponseEntity<CartDTO> addItem2Cart(@PathVariable Long userId,
                                                    @PathVariable Long itemId){
        return ResponseEntity.ok().body(this.cartService.addItem2Cart(userId,itemId));
        }


    @DeleteMapping("/{userId}/delete/{itemId}")
    public ResponseEntity<CartDTO> removeItemFromCart(@PathVariable Long userId,
                                                @PathVariable Long itemId){
        return ResponseEntity.ok().body(this.cartService.removeItemFromCart(userId,itemId));
    }
}
