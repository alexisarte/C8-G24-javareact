package com.nocountry.No_Country.controller;

import com.nocountry.No_Country.dtos.*;
import com.nocountry.No_Country.entity.AnimalEnum;
import com.nocountry.No_Country.entity.Cart;
import com.nocountry.No_Country.entity.CategoryEnum;
import com.nocountry.No_Country.mapper.CartMapper;
import com.nocountry.No_Country.service.CartService;
import com.nocountry.No_Country.service.ItemService;
import com.nocountry.No_Country.service.LocationService;
import com.nocountry.No_Country.service.UserService;
import com.nocountry.No_Country.utils.FinalPage;
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
    private final CartMapper cartMapper;
    private final ItemService itemService;

    @Autowired
    public UserController(UserService userService, LocationService locationService, CartService cartService, CartMapper cartMapper, ItemService itemService) {

        this.userService = userService;
        this.locationService = locationService;
        this.cartService = cartService;
        this.cartMapper = cartMapper;
        this.itemService = itemService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = this.userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }


    @GetMapping("/items")
    public ResponseEntity<FinalPage> getAllItemsByFilters(@RequestParam(required = false, defaultValue = "1") int page,
                                                          @RequestParam(required = false) String name,
                                                          @RequestParam(required = false) CategoryEnum categoryEnum,
                                                          @RequestParam(required = false) AnimalEnum animalEnum){
        FinalPage itemsByFilters = itemService.getItemsByFilters(page,name,animalEnum,categoryEnum);
        return new ResponseEntity<>(itemsByFilters, HttpStatus.OK);
    }
    @GetMapping("/location/{id}")
    public ResponseEntity<BasicLocationDTO> getLocationById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.locationService.getLocationById(id));
    }




    @GetMapping("/{userId}")
    public ResponseEntity<BasicUserDTO> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @GetMapping("{userId}/cartResume")
    public ResponseEntity<BasicCartDTO> getCartResume(@PathVariable Long userId){
        return ResponseEntity.ok().body(cartService.seeCartResume(userId));
    }

    @GetMapping("/{userId}/itemNearMe/{itemId}")
    public ResponseEntity<List<String>> getItemNearMe(@PathVariable Long userId,
                                                      @PathVariable Long itemId){
        return ResponseEntity.ok().body(userService.getItemsNearMe(userId, itemId));
    }

    @GetMapping("/{locationId}/{animal}/{category}")
        public ResponseEntity<List<BasicItemDTO>> getItemsOfCity(@PathVariable Long locationId,
                                                                 @PathVariable AnimalEnum animal,
                                                                 @PathVariable CategoryEnum category){
        List<BasicItemDTO> itemsByParameters = locationService.getLocationItemsByCategoryOrAnimal(locationId,
                animal, category);
        return new ResponseEntity<>(itemsByParameters,HttpStatus.OK);
        }

    @GetMapping("/{locationId}/{itemName}")
    public ResponseEntity<List<BasicItemDTO>> getItemsOfCityByName(@PathVariable Long locationId,
                                                                   @PathVariable String itemName){
        List<BasicItemDTO> itemsByName = locationService.getLocationItemsByName(locationId, itemName);
        return new ResponseEntity<>(itemsByName, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUserBeta(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createProvisionalUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PostMapping("{userId}/add/{itemId}")
        public ResponseEntity<CartDTO> addItem2Cart(@PathVariable Long userId,
                                                    @PathVariable Long itemId){
        return ResponseEntity.ok().body(this.cartService.addItem2Cart(userId,itemId));
        }
    @PostMapping("/addCartToUser/{userId}")
    public ResponseEntity<CartDTO> addCartToUser(@PathVariable Long userId){
        Cart cartEntity = cartService.createCartForNewUser(userId);
        CartDTO cart = cartMapper.cartEntity2DTO(cartEntity);
        return new ResponseEntity<>(cart, HttpStatus.OK);

    }

    @DeleteMapping("/{userId}/remove/{itemId}")
    public ResponseEntity<List<BasicItemDTO>> removeItemFromCart(@PathVariable Long userId,
                                                                 @PathVariable Long itemId){
        return ResponseEntity.ok().body(this.cartService.deleteOneItem(userId,itemId));
    }
}
