package com.example.services.impl;

import com.example.dto.ImageDTO;
import com.example.dto.UserDTO;
import com.example.entity.Image;
import com.example.entity.User;
import com.example.exception.EmailAlreadyExistsException;
import com.example.exception.ResourceNotFoundException;
import com.example.mapper.AutoUserMapper;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import com.example.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Convert UserDTO into User JPA Entity
//        User user = UserMapper.mapToUser(userDTO);

//        User user = modelMapper.map(userDTO, User.class);

        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDTO);

        User savedUser = userRepository.save(user);

        // Convert User JPA Entity to UserDTO
//        UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);

//        UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);

        UserDTO savedUserDTO = AutoUserMapper.MAPPER.mapToUserDto(user);
        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user =  userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        System.out.println("service: " + user);

        // custom modelmapper
//        modelMapper.addMappings(new PropertyMap<Image, ImageDTO>() {
//            protected void configure() {
//                map().setUrl(source.getName());
//            }
//        })
//        return UserMapper.mapToUserDTO(optionalUser.get());
//        return modelMapper.map(user, UserDTO.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }


    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDTO)
//                .collect(Collectors.toList());

//        return users.stream().map((user) -> modelMapper.map(user, UserDTO.class))
//                .collect(Collectors.toList());

        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto((user)))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return UserMapper.mapToUserDTO(updatedUser);
//        return modelMapper.map(updatedUser, UserDTO.class);

        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }


    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        userRepository.deleteById(userId);
    }
}
