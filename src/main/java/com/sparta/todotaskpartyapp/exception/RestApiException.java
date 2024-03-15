package com.sparta.todotaskpartyapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestApiException extends RuntimeException {
    private String errorMessage;
    private int statusCode;
}