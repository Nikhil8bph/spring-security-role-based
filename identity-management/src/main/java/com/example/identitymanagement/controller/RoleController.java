package com.example.identitymanagement.controller;

import com.example.identitymanagement.dto.request.CreateRoleRequest;
import com.example.identitymanagement.dto.request.UpdateRoleRequest;
import com.example.identitymanagement.dto.response.RoleResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.identitymanagement.resources.RoleResources;
import com.example.identitymanagement.service.RoleService;
import com.example.sharedkernel.constants.HttpStatusConstant;
import com.example.sharedkernel.dto.response.PageResponse;
import com.example.sharedkernel.dto.response.StandardResponse;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class RoleController implements RoleResources {
    private final RoleService roleService;

    @Override
    public StandardResponse<RoleResponse> create(CreateRoleRequest request) {
        RoleResponse response = roleService.create(request);
        return StandardResponse.<RoleResponse>builder()
                .data(response)
                .message("Role created successfully")
                .httpStatus(HttpStatusConstant.CREATED)
                .build();
    }

    @Override
    public StandardResponse<PageResponse<RoleResponse>> getPage(int page, int size, String search, Boolean active) {
        PageResponse<RoleResponse> response = roleService.getPage(page, size, search, active);
        return StandardResponse.<PageResponse<RoleResponse>>builder()
                .data(response)
                .message("Roles retrieved successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<RoleResponse> getById(String roleName) {
        RoleResponse response = roleService.getByName(roleName);
        return StandardResponse.<RoleResponse>builder()
                .data(response)
                .message("Role retrieved successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<RoleResponse> update(String roleName, UpdateRoleRequest request) {
        RoleResponse response = roleService.update(roleName, request);
        return StandardResponse.<RoleResponse>builder()
                .data(response)
                .message("Role updated successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<Void> delete(String roleName) {
        roleService.delete(roleName);
        return StandardResponse.<Void>builder()
                .message("Role deleted successfully")
                .httpStatus(HttpStatusConstant.ACCEPTED)
                .build();
    }

    @Override
    public StandardResponse<RoleResponse> restore(String roleName) {
        RoleResponse response = roleService.restore(roleName);
        return StandardResponse.<RoleResponse>builder()
                .data(response)
                .message("Role restored successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<PageResponse<UserResponse>> getUsers(String roleName, int page, int size) {
        PageResponse<UserResponse> response = roleService.getUsers(roleName, page, size);
        return StandardResponse.<PageResponse<UserResponse>>builder()
                .data(response)
                .message("Users retrieved successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }
}

