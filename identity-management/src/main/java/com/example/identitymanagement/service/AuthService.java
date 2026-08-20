package com.example.identitymanagement.service;

import com.example.identitymanagement.dto.request.*;
import com.example.identitymanagement.dto.response.LoginResponse;
import com.example.identitymanagement.dto.response.TokenResponse;
import com.example.identitymanagement.dto.response.UserResponse;

public interface AuthService {
    UserResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

    TokenResponse refreshToken(RefreshTokenRequest request);

    void logout(LogoutRequest request);

    UserResponse getUser();

    void changePassword(ChangePasswordRequest request);

    void forgotPassword(ForgotPasswordRequest request);

    void resetPassword(ResetPasswordRequest request);
}
