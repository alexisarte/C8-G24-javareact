package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicUserDTO;
import com.nocountry.No_Country.dtos.UserDTO;
import com.nocountry.No_Country.entity.*;
import com.nocountry.No_Country.mapper.UserMapper;
import com.nocountry.No_Country.repository.CartRepository;
import com.nocountry.No_Country.repository.UserRepository;
import com.nocountry.No_Country.service.CartService;
import com.nocountry.No_Country.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper  userMapper;
    private final CartService cartService;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,CartService cartService ,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.cartService = cartService;

    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return (userMapper.userEntityList2DTOList(users));

    }

    public UserDTO createProvisionalUser(UserDTO userDTO){

        if (userRepository.findByEmail(userDTO.getEmail()) == null){

            User user = userMapper.userDTO2Entity(userDTO);

            User userSaved = userRepository.save(user);

            return userMapper.userEntity2DTO(userSaved);
        }
        else {
            throw new RuntimeException("User with this email already exists.");
        }
    }

    public String deleteUser(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(
                        ()-> new RuntimeException("Can't delete. User not found"));
        Cart cart = cartRepository.findById(user.getCart().getId())
                .orElseThrow(
                        ()-> new RuntimeException("Cart not found"));

        userRepository.delete(user);
        cartRepository.delete(cart);

        return("User: "+ user.getFirstName() + user.getLastName() +" has been deleted" );
    }

    public BasicUserDTO getUserById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        return userMapper.userEntity2BasicDTO(user);
    }

    public List<String> getItemsNearMe(Long userId, Long itemId){

        List<String> result = new ArrayList<>();

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        Location location = user.getLocation();

        List<Shop> shops = location.getShops();

        for (Shop shop : shops) {

            List<Item> shopItems = shop.getShopItems();

            for (Item item : shopItems) {
                if (Objects.equals(item.getId(), itemId)) {
                    result.add(item.getName() + (item.getPrice().toString())
                            + " available in shop "
                            + shop.getName()
                            + " located in: "
                            + shop.getStreetName());
                }
            }
        }
        return result;
    }


}
