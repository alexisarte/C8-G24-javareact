package com.nocountry.No_Country.service.serviceImpl;

import com.nocountry.No_Country.dtos.UserDTO;
import com.nocountry.No_Country.entity.User;
import com.nocountry.No_Country.mapper.UserMapper;
import com.nocountry.No_Country.repository.UserRepository;
import com.nocountry.No_Country.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper  userMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return (userMapper.userEntityList2DTOList(users));

    }



}
