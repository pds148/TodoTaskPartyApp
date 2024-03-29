package com.sparta.todotaskpartyapp.exception;

import com.sparta.todotaskpartyapp.dto.response.TodoResponseDTO;
import com.sparta.todotaskpartyapp.dto.response.TodoTaskResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<TodoTaskResponseDTO> handleUserIllegalArgumentException(UserNotFoundException e) {
        TodoTaskResponseDTO responseDTO = new TodoTaskResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TodoNotFoundException.class})
    public ResponseEntity<TodoResponseDTO> handleTodoIllegalArgumentException(TodoNotFoundException e) {
        TodoResponseDTO responseDTO = new TodoResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CommentNotFoundException.class})
    public ResponseEntity<TodoTaskResponseDTO> handleCommentIllegalArgumentException(CommentNotFoundException e) {
        TodoTaskResponseDTO responseDTO = new TodoTaskResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
