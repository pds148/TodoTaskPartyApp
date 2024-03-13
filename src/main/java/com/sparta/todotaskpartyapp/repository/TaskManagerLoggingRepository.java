package com.sparta.todotaskpartyapp.repository;

import com.sparta.todotaskpartyapp.entity.ApiTaskManager;
import com.sparta.todotaskpartyapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskManagerLoggingRepository extends JpaRepository<ApiTaskManager, Long> {
    Optional<ApiTaskManager> findByUser(User loginUser);
}
