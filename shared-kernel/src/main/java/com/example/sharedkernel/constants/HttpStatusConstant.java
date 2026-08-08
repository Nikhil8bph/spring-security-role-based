package com.example.sharedkernel.constants;

import lombok.Getter;

@Getter
public enum HttpStatusConstant {
    OK(200),
    CREATED(201),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    ACCEPTED(202),
    INTERNAL_SERVER_ERROR(500),
    CONFLICT(409),
    FORBIDDEN(403),
    UNAUTHORIZED(401);

    private final int code;

    HttpStatusConstant(int code) {
        this.code = code;
    }

}
