package com.sparta.todotaskpartyapp.dto.response;

import lombok.Getter;

@Getter
public class ThreadResponseDTO {
    private Long id;
    private String title;
    private String content;

    public ThreadResponseDTO(Long threadId, String title) {
        this.id = threadId;
        this.title = title;
    }
}
