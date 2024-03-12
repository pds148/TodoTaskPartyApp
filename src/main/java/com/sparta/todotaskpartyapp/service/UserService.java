package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.request.LoginRequestDTO;
import com.sparta.todotaskpartyapp.dto.request.SignupRequestDTO;
import com.sparta.todotaskpartyapp.entity.User;

public interface UserService {

    void signupUser(SignupRequestDTO signupRequestDto);

    void loginUser(LoginRequestDTO loginRequestDTO);

    User getUserByUsername(String username);
}
