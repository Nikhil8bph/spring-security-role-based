package com.example.identitymanagement.service;

import com.example.identitymanagement.dto.request.RoleIdsRequest;
import com.example.identitymanagement.dto.request.UpdateUserRequest;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.sharedkernel.dto.response.PageResponse;

public interface UserService {
    PageResponse<UserResponse> getPage(int page, int size, String search, Boolean active);

    UserResponse getById(String userIdentifier);

    UserResponse update(String userIdentifier, UpdateUserRequest request);

    void delete(String userIdentifier);

    UserResponse restore(String userIdentifier);

    UserResponse replaceRoles(String userIdentifier, RoleIdsRequest request);

    UserResponse assignRole(String userIdentifier, String roleName);

    UserResponse removeRole(String userIdentifier, String roleName);
}
