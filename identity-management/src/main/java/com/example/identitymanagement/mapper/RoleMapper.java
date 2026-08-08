package com.example.identitymanagement.mapper;

import com.example.identitymanagement.dto.RoleDTO;
import com.example.identitymanagement.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleDTO roleDTO);
    RoleDTO toDTO(Role role);
}
