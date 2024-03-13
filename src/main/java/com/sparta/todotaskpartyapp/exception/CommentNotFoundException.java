package com.sparta.todotaskpartyapp.exception;

public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException() {
    }

    public CommentNotFoundException(String message) {
        super(message);
    }

    public CommentNotFoundException(String message, Throwable status) {
        super(message, status);
    }

    public CommentNotFoundException(Throwable status) {
        super(status);
    }
}
