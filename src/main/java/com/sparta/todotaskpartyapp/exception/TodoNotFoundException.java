package com.sparta.todotaskpartyapp.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException() {
    }

    public TodoNotFoundException(String message) {
        super(message);
    }

    public TodoNotFoundException(String message, Throwable status) {
        super(message, status);
    }

    public TodoNotFoundException(Throwable status) {
        super(status);
    }
}
