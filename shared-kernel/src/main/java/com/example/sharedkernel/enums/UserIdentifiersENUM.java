package com.example.sharedkernel.enums;

public enum UserIdentifiersENUM {
    PHONE("phone"),
    EMAIL("email"),
    USERNAME("username");

    private final String identifier;

    UserIdentifiersENUM(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
