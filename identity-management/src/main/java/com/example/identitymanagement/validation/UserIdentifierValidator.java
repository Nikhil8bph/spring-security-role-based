package com.example.identitymanagement.validation;

import com.example.sharedkernel.enums.UserIdentifiersENUM;
import org.springframework.stereotype.Component;

@Component
public class UserIdentifierValidator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_REGEX = "^\\+?[1-9]\\d{1,14}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._-]{3,20}$";

    public UserIdentifiersENUM validate(String userIdentifier) {
        isValid(userIdentifier);
        return getIdentifierType(userIdentifier);
    }

    private void isValid(String identifier) {
        if (identifier == null || !(identifier.matches(EMAIL_REGEX) || identifier.matches(PHONE_REGEX) || identifier.matches(USERNAME_REGEX))) {
            throw new IllegalArgumentException("Invalid identifier format");
        }
    }

    private UserIdentifiersENUM getIdentifierType(String identifier) {
        if (identifier.matches(EMAIL_REGEX)) {
            return UserIdentifiersENUM.EMAIL;
        } else if (identifier.matches(PHONE_REGEX)) {
            return UserIdentifiersENUM.PHONE;
        } else if (identifier.matches(USERNAME_REGEX)) {
            return UserIdentifiersENUM.USERNAME;
        }
        throw new IllegalArgumentException("Invalid identifier format");
    }
}
