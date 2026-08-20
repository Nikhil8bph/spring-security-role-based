package com.example.identitymanagement.service.impl;

import com.example.identitymanagement.dto.response.RoleResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.identitymanagement.service.AdminService;
import com.example.sharedkernel.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    @Override
    public PageResponse<UserResponse> getUsers(int page, int size, String search, String sortBy, String sortDirection, boolean includeActive, boolean includeDeleted) {
        return null;
    }

    @Override
    public PageResponse<RoleResponse> getRoles(int page, int size, String search, String sortDirection, boolean includeActive, boolean includeDeleted) {
        return null;
    }
}
