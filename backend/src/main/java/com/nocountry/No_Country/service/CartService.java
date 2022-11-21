package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.CartDTO;

public interface CartService {

    CartDTO addItem2Cart(Long cartId, Long itemId);
}
