package com.sparta.todotaskpartyapp.exception;

import com.sparta.todotaskpartyapp.entity.User;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
