package com.sparta.todotaskpartyapp.exception;

import com.sparta.todotaskpartyapp.entity.User;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable status) {
        super(message, status);
    }

    public UserNotFoundException(Throwable status) {
        super(status);
    }
}
