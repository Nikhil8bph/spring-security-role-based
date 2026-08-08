package com.example.sharedkernel.dto.response;

import com.example.sharedkernel.constants.HttpStatusConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse<T> {
    private T data;
    private String message;
    private String error;
    private Instant timestamp = Instant.now();
    private HttpStatusConstant httpStatus;
}
