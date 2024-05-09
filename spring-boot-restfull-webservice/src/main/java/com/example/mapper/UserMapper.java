package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.entity.User;

public class UserMapper {
    // convert User JPA Entity into UserDTO
    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

    // Convert User DTO into User JPA Entity
    public static User mapToUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
