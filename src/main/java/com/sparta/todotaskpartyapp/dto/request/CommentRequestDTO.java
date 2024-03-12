package com.sparta.todotaskpartyapp.dto.request;

import lombok.Getter;

@Getter
public class CommentRequestDTO {

    private String commentContent;
    private Long todoId;
}
