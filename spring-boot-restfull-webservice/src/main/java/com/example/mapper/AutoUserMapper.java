package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface AutoUserMapper {

//    @Mapping(source = "email", target = "emailAddress")
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDTO mapToUserDto(User user);

    User mapToUser(UserDTO userDTO);
}
