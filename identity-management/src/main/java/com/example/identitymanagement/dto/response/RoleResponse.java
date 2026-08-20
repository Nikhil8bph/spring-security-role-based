package com.example.identitymanagement.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

record RoleResponse(
        UUID id,
        String name,
        Long roleLevel,
        String description,
        Boolean canDelete,
        Boolean canUpdate,
        Boolean isDeleted,
        Boolean isActive) {
}
