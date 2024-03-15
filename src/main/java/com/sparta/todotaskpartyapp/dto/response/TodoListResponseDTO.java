package com.sparta.todotaskpartyapp.dto.response;

import com.sparta.todotaskpartyapp.dto.request.UserRequestDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class TodoListResponseDTO {
    private UserRequestDTO user;
    private List<TodoResponseDTO> todoList;

    public TodoListResponseDTO(UserRequestDTO user, List<TodoResponseDTO> todoList) {
        this.user = user;
        this.todoList = todoList;
    }
}