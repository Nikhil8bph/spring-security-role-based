package com.example.identitymanagement.controller;

import com.example.identitymanagement.dto.request.CreateUserRequest;
import com.example.identitymanagement.dto.request.RoleIdsRequest;
import com.example.identitymanagement.dto.request.UpdateUserRequest;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.identitymanagement.resources.UserResources;
import com.example.identitymanagement.service.UserService;
import com.example.sharedkernel.constants.HttpStatusConstant;
import com.example.sharedkernel.dto.response.PageResponse;
import com.example.sharedkernel.dto.response.StandardResponse;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UserController implements UserResources {
    private final UserService userService;

    @Override
    public StandardResponse<PageResponse<UserResponse>> getPage(int page, int size, String search, Boolean active) {
        PageResponse<UserResponse> response = userService.getPage(page, size, search, active);
        return StandardResponse.<PageResponse<UserResponse>>builder()
                .data(response)
                .message("Users retrieved successfully")
                .httpStatus(HttpStatusConstant.OK)
                    .build();
    }

    @Override
    public StandardResponse<UserResponse> getById(String userIdentifier) {
        UserResponse response = userService.getById(userIdentifier);
        return StandardResponse.<UserResponse>builder()
                .data(response)
                .message("User retrieved successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<UserResponse> update(String userIdentifier, UpdateUserRequest request) {
        UserResponse response = userService.update(userIdentifier, request);
        return StandardResponse.<UserResponse>builder()
                .data(response)
                .message("User updated successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<Void> delete(String userIdentifier) {
        userService.delete(userIdentifier);
        return StandardResponse.<Void>builder()
                .message("User deleted successfully")
                .httpStatus(HttpStatusConstant.ACCEPTED)
                .build();
    }

    @Override
    public StandardResponse<UserResponse> restore(String userIdentifier) {
        UserResponse response = userService.restore(userIdentifier);
        return StandardResponse.<UserResponse>builder()
                .data(response)
                .message("User restored successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<UserResponse> replaceRoles(String userIdentifier, RoleIdsRequest request) {
        UserResponse response = userService.replaceRoles(userIdentifier, request);
        return StandardResponse.<UserResponse>builder()
                .data(response)
                .message("User roles replaced successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<UserResponse> assignRole(String userIdentifier, String roleName) {
        UserResponse response = userService.assignRole(userIdentifier, roleName);
        return StandardResponse.<UserResponse>builder()
                .data(response)
                .message("Role assigned to user successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<UserResponse> removeRole(String userIdentifier, String roleName) {
        UserResponse response = userService.removeRole(userIdentifier, roleName);
        return StandardResponse.<UserResponse>builder()
                .data(response)
                .message("Role removed from user successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }
}
