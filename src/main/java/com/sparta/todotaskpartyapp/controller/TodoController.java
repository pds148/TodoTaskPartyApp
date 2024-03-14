package com.sparta.todotaskpartyapp.controller;

import com.sparta.todotaskpartyapp.dto.request.TodoRequestDTO;
import com.sparta.todotaskpartyapp.dto.response.TodoListResponseDTO;
import com.sparta.todotaskpartyapp.dto.response.TodoResponseDTO;
import com.sparta.todotaskpartyapp.security.UserDetailsImpl;
import com.sparta.todotaskpartyapp.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDTO> addTodo(
            @RequestBody TodoRequestDTO todoRequestDTO,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        TodoResponseDTO todoResponseDTO = todoService.createTodo(todoRequestDTO, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(todoResponseDTO);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponseDTO> getTodoDetails(@PathVariable Long todoId) {
        TodoResponseDTO responseDTO = todoService.getTodoDetails(todoId);
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<TodoListResponseDTO>> getUserTodoList() {
        List<TodoListResponseDTO> response = todoService.getUserTodoList();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoResponseDTO> updateTodo(
            @PathVariable Long todoId,
            @RequestBody TodoRequestDTO todoRequestDTO,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        TodoResponseDTO responseDTO = todoService.updateTodo(todoId, todoRequestDTO, userDetails.getUser());
        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("/{todoId}/complete")
    public ResponseEntity<TodoResponseDTO> completeTodo(
            @PathVariable Long todoId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        TodoResponseDTO responseDTO = todoService.completeTodo(todoId, userDetails.getUser());
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<TodoResponseDTO> deleteTodo(
            @PathVariable Long todoId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        todoService.deleteTodo(todoId, userDetails.getUser());
        return ResponseEntity.ok().body(new TodoResponseDTO("할일이 삭제되었습니다.", HttpStatus.OK.value()));
    }
}

