package com.example.identitymanagement.controller;

import com.example.identitymanagement.dto.response.RoleResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.identitymanagement.resources.AdminResources;
import com.example.identitymanagement.service.AdminService;
import com.example.sharedkernel.constants.HttpStatusConstant;
import com.example.sharedkernel.dto.response.PageResponse;
import com.example.sharedkernel.dto.response.StandardResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdminController implements AdminResources {
    private final AdminService adminService;

    @Override
    public StandardResponse<PageResponse<UserResponse>> getUsers(int page, int size, String search, String sortBy, String sortDirection, boolean includeActive, boolean includeDeleted) {
        PageResponse<UserResponse> userResponsePageResponse = adminService.getUsers(page, size, search, sortBy, sortDirection, includeActive, includeDeleted);
        return StandardResponse.<PageResponse<UserResponse>>builder()
                .message("Users retrieved successfully")
                .httpStatus(HttpStatusConstant.OK)
                .data(userResponsePageResponse)
                .build();
    }

    @Override
    public StandardResponse<PageResponse<RoleResponse>> getRoles(int page, int size, String search, String sortDirection, boolean includeActive, boolean includeDeleted) {
        PageResponse<RoleResponse> roleResponsePageResponse = adminService.getRoles(page, size, search, sortDirection, includeActive, includeDeleted);
        return StandardResponse.<PageResponse<RoleResponse>>builder()
                .message("Roles retrieved successfully")
                .httpStatus(HttpStatusConstant.OK)
                .data(roleResponsePageResponse)
                .build();
    }
}
