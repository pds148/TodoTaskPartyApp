package com.sparta.todotaskpartyapp.exception;

import com.sparta.todotaskpartyapp.dto.response.TodoResponseDTO;
import com.sparta.todotaskpartyapp.dto.response.TodoTaskResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomValidationException.class})
    public ResponseEntity<TodoTaskResponseDTO> handleUserIllegalArgumentException(CustomValidationException e) {
        TodoTaskResponseDTO responseDTO = new TodoTaskResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomValidationException.class})
    public ResponseEntity<TodoResponseDTO> handleTodoIllegalArgumentException(CustomValidationException e) {
        TodoResponseDTO responseDTO = new TodoResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomValidationException.class})
    public ResponseEntity<TodoTaskResponseDTO> handleCommentIllegalArgumentException(CustomValidationException e) {
        TodoTaskResponseDTO responseDTO = new TodoTaskResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
