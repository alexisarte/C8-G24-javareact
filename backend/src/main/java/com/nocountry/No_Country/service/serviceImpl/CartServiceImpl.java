package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.CartDTO;
import com.nocountry.No_Country.dtos.ItemDTO;
import com.nocountry.No_Country.entity.Cart;
import com.nocountry.No_Country.entity.Item;
import com.nocountry.No_Country.entity.User;
import com.nocountry.No_Country.mapper.CartMapper;
import com.nocountry.No_Country.mapper.ItemMapper;
import com.nocountry.No_Country.repository.CartRepository;
import com.nocountry.No_Country.repository.ItemRepository;
import com.nocountry.No_Country.repository.UserRepository;
import com.nocountry.No_Country.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private UserRepository userRepository;

    public CartDTO addItem2Cart(Long userId, Long itemId){

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        Cart cart = cartRepository.findById(
                user.getCart().getId()).orElseThrow(
                        ()-> new RuntimeException("No cart was found on this  user"));

        Item item = itemRepository.findById(itemId).orElseThrow(
                ()->new RuntimeException("Item not found"));

        List<Item> cartItems = cart.getItems();

        cartItems.add(item);

        cartRepository.save(cart);

        return cartMapper.cartEntity2DTO(cart);

    }
}
