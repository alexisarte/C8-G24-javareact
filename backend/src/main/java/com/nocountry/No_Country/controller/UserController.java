package com.nocountry.No_Country.controller;

import com.nocountry.No_Country.dtos.*;
import com.nocountry.No_Country.entity.Cart;
import com.nocountry.No_Country.mapper.CartMapper;
import com.nocountry.No_Country.service.CartService;
import com.nocountry.No_Country.service.LocationService;
import com.nocountry.No_Country.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private CartMapper cartMapper;
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
        return ResponseEntity.ok().body(this.locationService.getLocationById(id));
    }

    @PostMapping("{userId}/add/{itemId}")
        public ResponseEntity<CartDTO> addItem2Cart(@PathVariable Long userId,
                                                    @PathVariable Long itemId){
        return ResponseEntity.ok().body(this.cartService.addItem2Cart(userId,itemId));
        }


    @DeleteMapping("/{userId}/delete/{itemId}")
    public ResponseEntity<List<BasicItemDTO>> removeItemFromCart(@PathVariable Long userId,
                                                                 @PathVariable Long itemId){
        return ResponseEntity.ok().body(this.cartService.deleteOneItem(userId,itemId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BasicUserDTO> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @GetMapping("{userId}/cart/resume")
    public ResponseEntity<BasicCartDTO> getCartResume(@PathVariable Long userId){
        return ResponseEntity.ok().body(cartService.seeCartResume(userId));
    }

    @GetMapping("/{userId}/itemNearMe/{itemId}")
    public ResponseEntity<List<String>> getItemNearMe(@PathVariable Long userId,
                                                      @PathVariable Long itemId){
        return ResponseEntity.ok().body(userService.getItemsNearMe(userId, itemId));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUserBeta(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createProvisionalUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PostMapping("/addCartToUser/{userId}")
    public ResponseEntity<CartDTO> addCartToUser(@PathVariable Long userId){
        Cart cartEntity = cartService.createCartForNewUser(userId);
        CartDTO cart = cartMapper.cartEntity2DTO(cartEntity);
        return new ResponseEntity<>(cart, HttpStatus.OK);

    }

}
