package com.example.identitymanagement.service;

import com.example.identitymanagement.dto.request.CreateRoleRequest;
import com.example.identitymanagement.dto.request.UpdateRoleRequest;
import com.example.identitymanagement.dto.response.RoleResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.sharedkernel.dto.response.PageResponse;

public interface RoleService {
    RoleResponse create(CreateRoleRequest request);

    RoleResponse getByName(String roleName);

    PageResponse<RoleResponse> getPage(int page, int size, String search, Boolean active);

    void delete(String roleName);

    RoleResponse restore(String roleName);

    PageResponse<UserResponse> getUsers(String roleName, int page, int size);

    RoleResponse update(String roleName, UpdateRoleRequest request);
}
