package com.example.identitymanagement.mapper;

import com.example.identitymanagement.dto.UserDTO;
import com.example.identitymanagement.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
