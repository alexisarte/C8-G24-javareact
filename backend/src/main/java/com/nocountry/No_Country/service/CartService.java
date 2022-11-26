package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.BasicCartDTO;
import com.nocountry.No_Country.dtos.BasicItemDTO;
import com.nocountry.No_Country.dtos.CartDTO;
import com.nocountry.No_Country.entity.Cart;

import java.util.List;

public interface CartService {

    CartDTO addItem2Cart(Long cartId, Long itemId);
    Cart createCartForNewUser(Long userId);
    Double getCartAmount(Cart cart);
    BasicCartDTO seeCartResume(Long userId);
    List<BasicItemDTO> deleteOneItem(Long userId, Long itemId);
}
