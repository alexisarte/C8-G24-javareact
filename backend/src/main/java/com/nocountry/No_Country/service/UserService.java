package com.nocountry.No_Country.service;

import com.nocountry.No_Country.dtos.BasicUserDTO;
import com.nocountry.No_Country.dtos.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
    String deleteUser(Long userId);
    BasicUserDTO getUserById(Long userId);
}
