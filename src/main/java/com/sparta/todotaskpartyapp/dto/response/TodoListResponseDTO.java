package com.sparta.todotaskpartyapp.dto.response;

import com.sparta.todotaskpartyapp.dto.request.UserDTO;
import com.sparta.todotaskpartyapp.entity.Todo;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class TodoListResponseDTO {
    private UserDTO user;
    private List<TodoResponseDTO> todoList;

    public TodoListResponseDTO(UserDTO user, List<TodoResponseDTO> todoList) {
        this.user = user;
        this.todoList = todoList;
    }
}