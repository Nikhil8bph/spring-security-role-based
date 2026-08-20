package com.example.identitymanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank String identifier,
        @NotBlank @Size(min = 8, max = 100) String password) {
}
