package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.CartDTO;
import com.nocountry.No_Country.entity.Cart;

public interface CartService {

    CartDTO addItem2Cart(Long cartId, Long itemId);
    CartDTO removeItemFromCart(Long userId, Long itemId);
    Cart createCartForNewUser(Long userId);
}
