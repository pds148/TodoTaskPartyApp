package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.request.LoginRequestDTO;
import com.sparta.todotaskpartyapp.dto.request.SignupRequestDTO;

public interface UserService {

    void signupUser(SignupRequestDTO signupRequestDto);

    void loginUser(LoginRequestDTO loginRequestDTO);
}
