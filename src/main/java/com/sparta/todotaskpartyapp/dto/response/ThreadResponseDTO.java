package com.sparta.todotaskpartyapp.dto.response;

import com.sparta.todotaskpartyapp.entity.Thread;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ThreadResponseDTO {
    private Long id;
    private String content;
    private String createdAt;
    private String username;

    public ThreadResponseDTO(Thread thread) {
        this.id = thread.getId();
        this.content = thread.getContent();
        this.username = thread.getUsername();
    }
}
