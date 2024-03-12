package com.streamAPI.StreamAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException() {
        super("First name or last name cannot be empty");
    }
}
