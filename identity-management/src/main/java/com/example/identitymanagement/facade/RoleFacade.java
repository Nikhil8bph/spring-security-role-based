package com.example.identitymanagement.facade;

import com.example.identitymanagement.mapper.RoleMapper;
import com.example.identitymanagement.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleFacade {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    //TODO create role

    //TODO update role

    //TODO restore role

    //TODO delete role

    //TODO get role paged with filters
}
