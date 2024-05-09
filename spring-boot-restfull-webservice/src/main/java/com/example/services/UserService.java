package com.example.services;

import com.example.dto.UserDTO;
import com.example.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long userId);
}
