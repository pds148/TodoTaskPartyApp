package com.sparta.todotaskpartyapp.todo;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import com.sparta.todotaskpartyapp.config.JpaConfig;
import com.sparta.todotaskpartyapp.repository.TodoRepository;
import com.sparta.todotaskpartyapp.repository.UserRepository;
import com.sparta.todotaskpartyapp.test.TodoTest;
import com.sparta.todotaskpartyapp.test.TodoTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(JpaConfig.class)
@Rollback(value = false)
class TodoRepositoryTest implements TodoTest {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.save(TEST_USER);
    }

    @Test
    @DisplayName("생성일시 기준 내림차순 정렬 조회")
    void findAll(){
        // given
        var testTodo1 = TodoTestUtils.get(TEST_TODO, 1L, LocalDateTime.now().minusMinutes(2), TEST_USER);
        var testTodo2 = TodoTestUtils.get(TEST_TODO, 2L, LocalDateTime.now().minusMinutes(1), TEST_USER);
        var testTodo3 = TodoTestUtils.get(TEST_TODO, 3L, LocalDateTime.now(), TEST_USER);
        todoRepository.save(testTodo1);
        todoRepository.save(testTodo2);
        todoRepository.save(testTodo3);

        // when
        var resultTodoList = todoRepository.findAll(Sort.by(Sort.Direction.DESC, "createDate"));

        // then
        assertThat(resultTodoList.get(0)).isEqualTo(testTodo3);
        assertThat(resultTodoList.get(1)).isEqualTo(testTodo2);
        assertThat(resultTodoList.get(2)).isEqualTo(testTodo1);
    }
}