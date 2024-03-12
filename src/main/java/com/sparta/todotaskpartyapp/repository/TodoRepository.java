package com.sparta.todotaskpartyapp.repository;

import com.sparta.todotaskpartyapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
