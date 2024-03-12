package com.sparta.todotaskpartyapp.dto.response;

import com.sparta.todotaskpartyapp.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDTO extends TodosResponseDTO {

    private Long id;
    private String commentContent;
    private UsersRequestDTO user;
    private LocalDateTime createDate;

    public CommentResponseDTO(Comment comment) {
        this.id = comment.getId();
        this.commentContent = comment.getCommentContent();
        this.user = new UsersRequestDTO(comment.getUser());
        this.createDate = comment.getCreateDate();
    }
}
