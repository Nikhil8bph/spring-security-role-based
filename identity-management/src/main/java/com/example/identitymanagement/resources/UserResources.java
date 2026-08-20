package com.example.identitymanagement.resources;

import com.example.identitymanagement.dto.request.CreateUserRequest;
import com.example.identitymanagement.dto.request.UpdateUserRequest;
import com.example.identitymanagement.dto.request.RoleIdsRequest;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.sharedkernel.dto.response.PageResponse;
import com.example.sharedkernel.dto.response.StandardResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Users")
@RestController
@RequestMapping("/api/v1/users")
public interface UserResources {

    @GetMapping
    StandardResponse<PageResponse<UserResponse>> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Boolean active);

    @GetMapping("/{userIdentifier}")
    StandardResponse<UserResponse> getById(@PathVariable String userIdentifier);

    @PutMapping("/{userIdentifier}")
    StandardResponse<UserResponse> update(
            @PathVariable String userIdentifier,
            @Valid @RequestBody UpdateUserRequest request);

    @DeleteMapping("/{userIdentifier}")
    StandardResponse<Void> delete(@PathVariable String userIdentifier);

    @PostMapping("/{userIdentifier}/restore")
    StandardResponse<UserResponse> restore(@PathVariable String userIdentifier);

    @PutMapping("/{userIdentifier}/roles")
    StandardResponse<UserResponse> replaceRoles(
            @PathVariable String userIdentifier,
            @Valid @RequestBody RoleIdsRequest request);

    @PostMapping("/{userIdentifier}/roles/{roleName}")
    StandardResponse<UserResponse> assignRole(
            @PathVariable String userIdentifier,
            @PathVariable String roleName);

    @DeleteMapping("/{userIdentifier}/roles/{roleName}")
    StandardResponse<UserResponse> removeRole(
            @PathVariable String userIdentifier,
            @PathVariable String roleName);
}
