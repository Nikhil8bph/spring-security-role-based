package com.example.identitymanagement.service.impl;

import com.example.identitymanagement.dto.UserDTO;
import com.example.identitymanagement.dto.request.*;
import com.example.identitymanagement.dto.response.LoginResponse;
import com.example.identitymanagement.dto.response.TokenResponse;
import com.example.identitymanagement.dto.response.UserResponse;
import com.example.identitymanagement.facade.UserFacade;
import com.example.identitymanagement.mapper.UserMapper;
import com.example.identitymanagement.service.AuthService;
import com.example.identitymanagement.validation.LoginRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final LoginRequestValidator loginRequestValidator;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserFacade userFacade;

    @Value("default.role.name")
    private String defaultRoleName;

    @Override
    public UserResponse register(RegisterRequest request) {
        userFacade.userExists(request.mobileNumber(), request.email());
        String encodedPassword = passwordEncoder.encode(request.password());
        UserDTO userDTO = userMapper.fromRequestToDTO(request);
        userDTO.setPassword(encodedPassword);
        UserDTO userDTOSaved = userFacade.createUser(userDTO, defaultRoleName);
        return userMapper.fromDTOToResponse(userDTOSaved);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        loginRequestValidator.validate(request);
        return null;
    }

    @Override
    public TokenResponse refreshToken(RefreshTokenRequest request) {
        return null;
    }

    @Override
    public void logout(LogoutRequest request) {

    }

    @Override
    public UserResponse getUser() {
        return null;
    }

    @Override
    public void changePassword(ChangePasswordRequest request) {

    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {

    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {

    }
}
