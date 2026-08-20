package com.example.identitymanagement.service;

import com.example.identitymanagement.dto.response.RoleResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.sharedkernel.dto.response.PageResponse;

public interface AdminService {
    PageResponse<UserResponse> getUsers(int page, int size, String search, String sortBy, String sortDirection, boolean includeActive, boolean includeDeleted);

    PageResponse<RoleResponse> getRoles(int page, int size, String search, String sortDirection, boolean includeActive, boolean includeDeleted);
}
