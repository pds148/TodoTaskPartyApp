package com.sparta.todotaskpartyapp.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreadResponseDTO {
    private Long id;
    private String title;
    private String content;

    public ThreadResponseDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
