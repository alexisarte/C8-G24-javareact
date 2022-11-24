package com.nocountry.No_Country.mapper;

import com.nocountry.No_Country.dtos.BasicUserDTO;
import com.nocountry.No_Country.dtos.UserDTO;
import com.nocountry.No_Country.entity.User;
import com.nocountry.No_Country.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    private final CartRepository cartRepository;
    private final LocationMapper locationMapper;
    private final CartMapper cartMapper;
    @Autowired
    public UserMapper(CartRepository cartRepository, LocationMapper locationMapper, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.locationMapper = locationMapper;
        this.cartMapper = cartMapper;
    }

    public UserDTO userEntity2DTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setCartDTO(cartMapper.cartEntity2DTO(user.getCart()));
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setLocationId(locationMapper.locationEntity2DTO(user.getLocation()));
        return dto;

    }
    public User userDTO2Entity(UserDTO dto){
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLocation(locationMapper.locationDTO2Entity(dto.getLocationId()));
        user.setCart(cartRepository.findById(dto.getCartDTO().getId()).orElseThrow());
        return user;
    }


    public List<UserDTO> userEntityList2DTOList(List<User> users){
        List<UserDTO> userDTOS = new ArrayList<>();

        for(User user : users){
            userDTOS.add(this.userEntity2DTO(user));
        }
        return userDTOS;
    }

    public BasicUserDTO userEntity2BasicDTO(User user){
        BasicUserDTO basicUserDTO = new BasicUserDTO();

        basicUserDTO.setCartDTO(cartMapper.cartEntity2BasicDTO(user.getCart()));
        basicUserDTO.setFirstName(user.getFirstName());
        basicUserDTO.setLastName(user.getLastName());
        basicUserDTO.setLocationId(user.getLocation().getLocation_id());
        return basicUserDTO;
    }
}
