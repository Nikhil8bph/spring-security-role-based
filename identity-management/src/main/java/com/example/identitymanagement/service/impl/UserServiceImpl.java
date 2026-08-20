package com.example.identitymanagement.service.impl;

import com.example.identitymanagement.dto.request.RoleIdsRequest;
import com.example.identitymanagement.dto.request.UpdateUserRequest;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.identitymanagement.service.UserService;
import com.example.identitymanagement.validation.UserIdentifierValidator;
import com.example.sharedkernel.enums.UserIdentifiersENUM;
import com.example.sharedkernel.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserIdentifierValidator userIdentifierValidator;

    @Override
    public PageResponse<UserResponse> getPage(int page, int size, String search, Boolean active) {
        return null;
    }

    @Override
    public UserResponse getById(String userIdentifier) {
        UserIdentifiersENUM userIdentifierType = userIdentifierValidator.validate(userIdentifier);
        return null;
    }

    @Override
    public UserResponse update(String userIdentifier, UpdateUserRequest request) {
        UserIdentifiersENUM userIdentifierType = userIdentifierValidator.validate(userIdentifier);
        return null;
    }

    @Override
    public void delete(String userIdentifier) {
        UserIdentifiersENUM userIdentifierType = userIdentifierValidator.validate(userIdentifier);
    }

    @Override
    public UserResponse restore(String userIdentifier) {
        return null;
    }

    @Override
    public UserResponse replaceRoles(String userIdentifier, RoleIdsRequest request) {
        userIdentifierValidator.validate(userIdentifier);
        return null;
    }

    @Override
    public UserResponse assignRole(String userIdentifier, String roleName) {
        return null;
    }

    @Override
    public UserResponse removeRole(String userIdentifier, String roleName) {
        return null;
    }
}
