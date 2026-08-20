package com.example.identitymanagement.dto.response;

import java.util.Set;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String firstName,
        String lastName,
        String username,
        String email,
        String mobileNumber,
        Set<String> roleIds,
        Boolean isDeleted,
        Boolean isActive) {
}
