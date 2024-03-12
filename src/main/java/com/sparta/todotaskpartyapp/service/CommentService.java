package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.request.CommentRequestDTO;
import com.sparta.todotaskpartyapp.dto.response.CommentResponseDTO;
import com.sparta.todotaskpartyapp.entity.User;

public interface CommentService {

    CommentResponseDTO createComment(CommentRequestDTO dto, User user);

    CommentResponseDTO updateComment(Long commentId, CommentRequestDTO commentRequestDTO, User user);

    void deleteComment(Long commentId, User user);
}
