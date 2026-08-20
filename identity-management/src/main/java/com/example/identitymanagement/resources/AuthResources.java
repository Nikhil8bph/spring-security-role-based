package com.example.identitymanagement.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth Resources")
@RestController
public interface AuthResources {

    @PostMapping("/auth/register")
    RegisterResponse register(RegisterRequest request);

    @PostMapping("/auth/login")
    LoginResponse login(LoginRequest request);

    @PostMapping("/auth/refresh-token")
    RefreshTokenResponse refreshToken(RefreshTokenRequest request);

    @PostMapping("/auth/logout")
    LogoutResponse logout(LogoutRequest request);

    @GetMapping("/auth/me")
    GetUserResponse getUser(GetUserRequest request);

    @PostMapping("/auth/change-password")
    ChangePasswordResponse changePassword(ChangePasswordRequest request);

    @PostMapping("/auth/forgot-password")
    ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request);

    @PostMapping("/auth/reset-password")
    ResetPasswordResponse resetPassword(ResetPasswordRequest request);
}
