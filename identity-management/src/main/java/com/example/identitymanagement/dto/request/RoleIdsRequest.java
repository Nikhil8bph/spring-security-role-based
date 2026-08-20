package com.example.identitymanagement.dto.request;

import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record RoleIdsRequest(@Size(min = 1, max = 20) List<String> roleNames) {
}
