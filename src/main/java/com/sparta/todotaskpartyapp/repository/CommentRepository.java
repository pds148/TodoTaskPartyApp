package com.sparta.todotaskpartyapp.repository;

import com.sparta.todotaskpartyapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
