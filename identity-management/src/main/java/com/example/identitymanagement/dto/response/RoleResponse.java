package com.example.identitymanagement.dto.response;

import java.util.Set;
import java.util.UUID;

public record RoleResponse(
        UUID id,
        String name,
        Long roleLevel,
        String description,
        Boolean canDelete,
        Boolean canUpdate,
        Boolean isDeleted,
        Boolean isActive) {
}
