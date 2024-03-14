package com.sparta.todotaskpartyapp.dto.response;

import com.sparta.todotaskpartyapp.entity.Thread;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ThreadSearchCondResponseDTO {
    private Long id;
    private String content;
    private String createdAt;
    private String username;

    public ThreadSearchCondResponseDTO(Thread thread) {
        this.id = thread.getId();
        this.content = thread.getContent();
        this.username = thread.getUsername();
    }
}