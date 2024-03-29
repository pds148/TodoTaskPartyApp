package com.sparta.todotaskpartyapp.dto.response;

import com.sparta.todotaskpartyapp.dto.request.UserRequestDTO;
import com.sparta.todotaskpartyapp.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDTO extends TodoTaskResponseDTO {

    private Long id;
    private String commentContent;
    private UserRequestDTO user;
    private LocalDateTime createDate;

    public CommentResponseDTO(Comment comment) {
        this.id = comment.getId();
        this.commentContent = comment.getCommentContent();
        this.user = new UserRequestDTO(comment.getUser());
        this.createDate = comment.getCreateDate();
    }
}
