package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.BasicUserDTO;
import com.nocountry.No_Country.dtos.UserDTO;
import com.nocountry.No_Country.entity.User;
import com.nocountry.No_Country.mapper.UserMapper;
import com.nocountry.No_Country.repository.UserRepository;
import com.nocountry.No_Country.service.CartService;
import com.nocountry.No_Country.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper  userMapper;
    private final CartService cartService;
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
        userSaved.setCart(cartService.createCartForNewUser(userSaved.getId()));

        return userMapper.userEntity2DTO(userSaved);
        }
        else{ throw new RuntimeException("User with this email already exists.");
        }
    }

    public String deleteUser(Long userId){

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        userRepository.delete(user);

        return("User: "+ user.getFirstName() + user.getLastName() +" has been deleted" );
    }

    public BasicUserDTO getUserById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not found"));

        return userMapper.userEntity2BasicDTO(user);
    }


}
