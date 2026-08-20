package com.example.identitymanagement.controller;

import com.example.identitymanagement.dto.request.*;
import com.example.identitymanagement.dto.response.LoginResponse;
import com.example.identitymanagement.dto.response.TokenResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.identitymanagement.resources.AuthResources;
import com.example.identitymanagement.service.AuthService;
import com.example.sharedkernel.constants.HttpStatusConstant;
import com.example.sharedkernel.dto.response.StandardResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthController implements AuthResources {
    private final AuthService authService;

    @Override
    public StandardResponse<UserResponse> register(RegisterRequest request) {
        UserResponse response = authService.register(request);
        return StandardResponse
                .<UserResponse>builder()
                .data(response)
                .message("User registered successfully")
                .httpStatus(HttpStatusConstant.CREATED)
                .build();
    }

    @Override
    public StandardResponse<LoginResponse> login(LoginRequest request) {
        LoginResponse response = authService.login(request);
        return StandardResponse
                .<LoginResponse>builder()
                .data(response)
                .message("User logged in successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<TokenResponse> refreshToken(RefreshTokenRequest request) {
        TokenResponse response = authService.refreshToken(request);
        return StandardResponse
                .<TokenResponse>builder()
                .data(response)
                .message("Token refreshed successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<Void> logout(LogoutRequest request) {
        authService.logout(request);
        return StandardResponse
                .<Void>builder()
                .message("User logged out successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<UserResponse> getUser() {
        UserResponse response = authService.getUser();
        return StandardResponse
                .<UserResponse>builder()
                .data(response)
                .message("User retrieved successfully")
                .httpStatus(HttpStatusConstant.OK)
                .build();
    }

    @Override
    public StandardResponse<Void> changePassword(ChangePasswordRequest request) {
        authService.changePassword(request);
        return StandardResponse
                .<Void>builder()
                .message("Password changed successfully")
                .httpStatus(HttpStatusConstant.ACCEPTED)
                .build();
    }

    @Override
    public StandardResponse<Void> forgotPassword(ForgotPasswordRequest request) {
        authService.forgotPassword(request);
        return StandardResponse
                .<Void>builder()
                .message("Password reset link sent successfully")
                .httpStatus(HttpStatusConstant.ACCEPTED)
                .build();
    }

    @Override
    public StandardResponse<Void> resetPassword(ResetPasswordRequest request) {
        authService.resetPassword(request);
        return StandardResponse
                .<Void>builder()
                .message("Password reset successfully")
                .httpStatus(HttpStatusConstant.ACCEPTED)
                .build();
    }
}
