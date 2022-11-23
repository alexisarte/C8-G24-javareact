package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.CartDTO;
import com.nocountry.No_Country.entity.Cart;
import com.nocountry.No_Country.entity.Item;
import com.nocountry.No_Country.entity.User;
import com.nocountry.No_Country.mapper.CartMapper;
import com.nocountry.No_Country.repository.CartRepository;
import com.nocountry.No_Country.repository.ItemRepository;
import com.nocountry.No_Country.repository.UserRepository;
import com.nocountry.No_Country.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final CartMapper cartMapper;
    private final UserRepository userRepository;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ItemRepository itemRepository, CartMapper cartMapper, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.cartMapper = cartMapper;
        this.userRepository = userRepository;
    }

    public CartDTO addItem2Cart(Long userId, Long itemId){

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        Cart cart = cartRepository.findById(
                user.getCart().getId()).orElseThrow(
                        ()-> new RuntimeException("No cart was found on this  user"));

        Item item = itemRepository.findById(itemId).orElseThrow(
                ()->new RuntimeException("Item not found"));

        cart.addItem(item);
        cartRepository.save(cart);
        return cartMapper.cartEntity2DTO(cart);

    }

    public CartDTO removeItemFromCart(Long userId, Long itemId){
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        Cart cart = cartRepository.findById(
                user.getCart().getId()).orElseThrow(
                ()-> new RuntimeException("No cart was found on this  user"));

        cart.deleteItem(itemId);
        cartRepository.save(cart);

        return cartMapper.cartEntity2DTO(cart);
    }

    public Cart createCartForNewUser(Long userId){
        Cart cart = new Cart();
        cart.setUser(userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found")));
        return cart;
    }
}
