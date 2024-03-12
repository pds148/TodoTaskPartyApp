package com.sparta.todotaskpartyapp.controller;

import com.sparta.todotaskpartyapp.dto.request.LoginRequestDTO;
import com.sparta.todotaskpartyapp.dto.request.SignupRequestDTO;
import com.sparta.todotaskpartyapp.dto.response.TodosResponseDTO;
import com.sparta.todotaskpartyapp.entity.User;
import com.sparta.todotaskpartyapp.entity.UserRole;
import com.sparta.todotaskpartyapp.jwt.JwtUtil;
import com.sparta.todotaskpartyapp.service.UserServiceImpl;
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

    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<TodosResponseDTO> postSignup(
            @Valid @RequestBody SignupRequestDTO signupRequestDto, BindingResult bindingResult) {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (!fieldErrors.isEmpty()) {
            for (FieldError fieldError : fieldErrors) {
                log.error("{} 필드 : {}", fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        userService.signupUser(signupRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED.value())
                .body(new TodosResponseDTO("회원가입 성공", HttpStatus.CREATED.value()));
    }

    @PostMapping("/login")
    public ResponseEntity<TodosResponseDTO> postLogin(
            @RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {

        userService.loginUser(loginRequestDTO);
        User user = userService.getUserByUsername(loginRequestDTO.getUsername());
        String username = user.getUsername();
        UserRole role = user.getRole();

        String token = jwtUtil.createToken(username, role);
        response.setHeader(JwtUtil.AUTHORIZATION_HEADER, token);

        return ResponseEntity.ok().body(new TodosResponseDTO("로그인 성공", HttpStatus.OK.value()));
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<TodosResponseDTO> handleIllegalArgumentException(IllegalArgumentException e) {
        TodosResponseDTO responseDTO = new TodosResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.BAD_REQUEST
        );
    }
}

