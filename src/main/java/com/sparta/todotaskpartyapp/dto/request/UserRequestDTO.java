package com.sparta.todotaskpartyapp.dto.request;

import com.sparta.todotaskpartyapp.entity.User;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserRequestDTO {
    private Long id;

    @Pattern(regexp = "^[a-z0-9]{4,10}$")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9]{8,15}$")
    private String password;

    public UserRequestDTO(User user) {
        this.username = user.getUsername();
    }

    public UserRequestDTO(Long userId) {
        this.id = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String Password) {
        this.password = password;
    }
}
