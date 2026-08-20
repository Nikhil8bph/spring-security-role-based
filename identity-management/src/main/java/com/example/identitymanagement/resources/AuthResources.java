package com.example.identitymanagement.resources;

import com.example.identitymanagement.dto.request.RegisterRequest;
import com.example.identitymanagement.dto.request.LoginRequest;
import com.example.identitymanagement.dto.request.RefreshTokenRequest;
import com.example.identitymanagement.dto.request.LogoutRequest;
import com.example.identitymanagement.dto.request.ChangePasswordRequest;
import com.example.identitymanagement.dto.request.ForgotPasswordRequest;
import com.example.identitymanagement.dto.request.ResetPasswordRequest;
import com.example.identitymanagement.dto.response.LoginResponse;
import com.example.identitymanagement.dto.response.TokenResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.sharedkernel.dto.response.StandardResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication")
@RestController
@RequestMapping("/api/v1/auth")
public interface AuthResources {

    @PostMapping("/register")
    StandardResponse<UserResponse> register(@Valid @RequestBody RegisterRequest request);

    @PostMapping("/login")
    StandardResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request);

    @PostMapping("/refresh-token")
    StandardResponse<TokenResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request);

    @PostMapping("/logout")
    StandardResponse<Void> logout(@Valid @RequestBody LogoutRequest request);

    @GetMapping("/me")
    StandardResponse<UserResponse> getUser();

    @PostMapping("/change-password")
    StandardResponse<Void> changePassword(@Valid @RequestBody ChangePasswordRequest request);

    @PostMapping("/forgot-password")
    StandardResponse<Void> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request);

    @PostMapping("/reset-password")
    StandardResponse<Void> resetPassword(@Valid @RequestBody ResetPasswordRequest request);
}
