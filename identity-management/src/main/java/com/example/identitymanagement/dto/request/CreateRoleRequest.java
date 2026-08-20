package com.example.identitymanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateRoleRequest(
        @NotBlank String name,
        @NotNull @PositiveOrZero Long roleLevel,
        @NotBlank String description,
        Boolean canDelete,
        Boolean canUpdate) {
}

