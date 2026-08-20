package com.example.identitymanagement.resources;

import com.example.identitymanagement.dto.request.CreateRoleRequest;
import com.example.identitymanagement.dto.request.UpdateRoleRequest;
import com.example.identitymanagement.dto.response.RoleResponse;
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

@Tag(name = "Roles")
@RestController
@RequestMapping("/api/v1/roles")
public interface RoleResources {

    @PostMapping
    StandardResponse<RoleResponse> create(@Valid @RequestBody CreateRoleRequest request);

    @GetMapping
    StandardResponse<PageResponse<RoleResponse>> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Boolean active);

    @GetMapping("/{roleName}")
    StandardResponse<RoleResponse> getById(@PathVariable String roleName);

    @PutMapping("/{roleName}")
    StandardResponse<RoleResponse> update(
            @PathVariable String roleName,
            @Valid @RequestBody UpdateRoleRequest request);

    @DeleteMapping("/{roleName}")
    StandardResponse<Void> delete(@PathVariable String roleName);

    @PostMapping("/{roleName}/restore")
    StandardResponse<RoleResponse> restore(@PathVariable String roleName);

    @GetMapping("/{roleName}/users")
    StandardResponse<PageResponse<UserResponse>> getUsers(
            @PathVariable String roleName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size);
}
