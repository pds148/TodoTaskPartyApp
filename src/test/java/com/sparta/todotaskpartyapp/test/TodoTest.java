package com.sparta.todotaskpartyapp.test;

import com.sparta.todotaskpartyapp.dto.request.TodoRequestDTO;
import com.sparta.todotaskpartyapp.dto.response.TodoResponseDTO;
import com.sparta.todotaskpartyapp.entity.Todo;


import static org.junit.jupiter.api.Assertions.*;

public interface TodoTest extends CommonTest {

    Long TEST_TODO_ID = 1L;
    String TEST_TODO_TITLE = "title";
    String TEST_TODO_CONTENT = "content";

    TodoRequestDTO TEST_TODO_REQUEST_DTO = TodoRequestDTO.builder()
            .todoTitle(TEST_TODO_TITLE)
            .todoContent(TEST_TODO_CONTENT)
            .build();
    TodoResponseDTO TEST_TODO_RESPONSE_DTO = TodoResponseDTO.builder()
            .todoTitle(TEST_TODO_TITLE)
            .todoContent(TEST_TODO_CONTENT)
            .build();
    Todo TEST_TODO = Todo.builder()
            .todoTitle(TEST_TODO_TITLE)
            .todoContent(TEST_TODO_CONTENT)
            .build();
    Todo TEST_ANOTHER_TODO = Todo.builder()
            .todoTitle(ANOTHER_PREFIX + TEST_TODO_TITLE)
            .todoContent(ANOTHER_PREFIX + TEST_TODO_CONTENT)
            .build();
}