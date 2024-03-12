package com.sparta.todotaskpartyapp.dto.request;

import com.sparta.todotaskpartyapp.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class UserDTO {
    private Long id;
    private String username;

    public UserDTO(User user) {
        this.username = user.getUsername();
    }

    public UserDTO(Long userId) {
        this.id = userId;
    }
}