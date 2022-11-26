package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicCartDTO;
import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.CartDTO;
import com.nocountry.No_Country.dtos.CartResumeDTO;
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

import java.util.*;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final CartMapper cartMapper;
    private final UserRepository userRepository;
    private final ItemMapper itemMapper;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository,ItemMapper itemMapper, ItemRepository itemRepository, CartMapper cartMapper, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.cartMapper = cartMapper;
        this.userRepository = userRepository;
        this.itemMapper = itemMapper;
        
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

    public Cart createCartForNewUser(Long userId){
        Cart cart = new Cart();
        cartRepository.save(cart);
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));
        cart.setUser(user);
        userRepository.save(user);
        return cart;
    }

    public Double getCartAmount(Cart cart){
        List<Item> items = cart.getItems();
        Double cont = 0.0;
        for(Item item : items){
            cont += item.getPrice();
        }
        return cont;
    }


    public List<BasicItemDTO> deleteOneItem(Long userId, Long itemId){

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));
        
        List<Item> cart = user.getCart().getItems();
        
        for(Item item :cart){
            if (Objects.equals(item.getId(), itemId)){
                cart.remove(item);
                break;
            }
        }
        userRepository.save(user);
        return itemMapper.itemEntityList2BasicDTOList(cart);
    }
    
    public BasicCartDTO seeCartResume(Long userId){

        BasicCartDTO basicCartDTO = new BasicCartDTO();

        List<CartResumeDTO> resumeArray = new ArrayList<>();  //Array for add items.
        
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        List<Item> cart = user.getCart().getItems();

        cart.sort(Comparator.comparing(Item::getId));  //check how many times these items are duplicated.

        for (Item item : cart) {
            CartResumeDTO cartResumeDTO = new CartResumeDTO();
            cartResumeDTO.setName(item.getName());
            cartResumeDTO.setStock(Collections.frequency(cart,item));
            resumeArray.add(cartResumeDTO);
        }

        List<CartResumeDTO> resume = new ArrayList<>(new HashSet<>(resumeArray)); //Remove duplicated strings

        basicCartDTO.setUser(user.getId());
        basicCartDTO.setItems(resume);
        basicCartDTO.setTotalAmount(this.getCartAmount(user.getCart()));


        return basicCartDTO;
    }
}
