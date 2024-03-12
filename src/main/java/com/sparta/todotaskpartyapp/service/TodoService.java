package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.request.TodoRequestDTO;
import com.sparta.todotaskpartyapp.dto.response.TodoListResponseDTO;
import com.sparta.todotaskpartyapp.dto.response.TodoResponseDTO;
import com.sparta.todotaskpartyapp.entity.User;

import java.util.List;

public interface TodoService {

    TodoResponseDTO createTodo(TodoRequestDTO todoRequestDTO, User user);

    TodoResponseDTO getTodoDetails(Long todoId);

    List<TodoListResponseDTO> getUserTodoList();

    TodoResponseDTO updateTodo(Long todoId, TodoRequestDTO todoRequestDTO, User user);

    TodoResponseDTO completeTodo(Long todoId, User user);

    void deleteTodo(Long todoId, User user);
}
