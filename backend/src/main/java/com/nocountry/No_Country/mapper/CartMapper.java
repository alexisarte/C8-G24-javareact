package com.nocountry.No_Country.mapper;

import com.nocountry.No_Country.dtos.CartDTO;
import com.nocountry.No_Country.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    private final ItemMapper itemMapper;
    @Autowired
    public CartMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public CartDTO cartEntity2DTO (Cart cart){
        CartDTO dto = new CartDTO();
        dto.setId(cart.getId());
        dto.setItems(itemMapper.itemEntityList2DTOList(cart.getItems()));
        dto.setLocalDateTime(cart.getLocalDateTime());
        dto.setUser(cart.getUser().getId());
        dto.setTotalAmount(cart.getTotalAmount());
        return dto;
    }

}
