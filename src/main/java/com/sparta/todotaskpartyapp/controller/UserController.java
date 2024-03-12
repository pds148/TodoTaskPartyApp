package com.sparta.todotaskpartyapp.controller;

import com.sparta.todotaskpartyapp.dto.request.LoginRequestDTO;
import com.sparta.todotaskpartyapp.dto.request.SignupRequestDTO;
import com.sparta.todotaskpartyapp.dto.response.TodoTaskResponseDTO;
import com.sparta.todotaskpartyapp.entity.User;
import com.sparta.todotaskpartyapp.entity.UserRole;
import com.sparta.todotaskpartyapp.jwt.JwtUtil;
import com.sparta.todotaskpartyapp.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@RestControllerAdvice
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<TodoTaskResponseDTO> signupUser(
            @Valid @RequestBody SignupRequestDTO signupRequestDto, BindingResult bindingResult) {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (!fieldErrors.isEmpty()) {
            for (FieldError fieldError : fieldErrors) {
                log.error("{} 필드 : {}", fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        userService.signupUser(signupRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED.value())
                .body(new TodoTaskResponseDTO("회원가입 성공", HttpStatus.CREATED.value()));
    }

    @PostMapping("/login")
    public ResponseEntity<TodoTaskResponseDTO> loginUser(
            @RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {

        userService.loginUser(loginRequestDTO);
        User user = userService.getUserByUsername(loginRequestDTO.getUsername());
        String username = user.getUsername();
        UserRole role = user.getRole();

        String token = jwtUtil.createToken(username, role);
        response.setHeader(JwtUtil.AUTHORIZATION_HEADER, token);

        return ResponseEntity.ok().body(new TodoTaskResponseDTO("로그인 성공", HttpStatus.OK.value()));
    }
}
