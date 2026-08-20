package com.example.identitymanagement.service.impl;

import com.example.identitymanagement.dto.request.CreateRoleRequest;
import com.example.identitymanagement.dto.request.UpdateRoleRequest;
import com.example.identitymanagement.dto.response.RoleResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.identitymanagement.service.RoleService;
import com.example.sharedkernel.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Override
    public RoleResponse create(CreateRoleRequest request) {
        return null;
    }

    @Override
    public RoleResponse getByName(String roleName) {
        return null;
    }

    @Override
    public PageResponse<RoleResponse> getPage(int page, int size, String search, Boolean active) {
        return null;
    }

    @Override
    public void delete(String roleName) {

    }

    @Override
    public RoleResponse restore(String roleName) {
        return null;
    }

    @Override
    public PageResponse<UserResponse> getUsers(String roleName, int page, int size) {
        return null;
    }

    @Override
    public RoleResponse update(String roleName, UpdateRoleRequest request) {
        return null;
    }
}
