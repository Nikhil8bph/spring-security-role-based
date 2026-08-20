package com.example.identitymanagement.validation;

import com.example.identitymanagement.dto.request.LoginRequest;
import com.example.identitymanagement.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginRequestValidator {
    private final UserIdentifierValidator userIdentifierValidator;

    public void validate(LoginRequest request){
        userIdentifierValidator.validate(request.identifier());
    }
}
