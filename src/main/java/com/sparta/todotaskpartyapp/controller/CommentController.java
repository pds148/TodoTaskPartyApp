package com.sparta.todotaskpartyapp.controller;

import com.sparta.todotaskpartyapp.dto.request.CommentRequestDTO;
import com.sparta.todotaskpartyapp.dto.response.CommentResponseDTO;
import com.sparta.todotaskpartyapp.dto.response.TodosResponseDTO;
import com.sparta.todotaskpartyapp.security.UserDetailsImpl;
import com.sparta.todotaskpartyapp.service.CommentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {

    private final CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDTO> postComment(@RequestBody CommentRequestDTO commentRequestDTO, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        CommentResponseDTO responseDTO = commentService.createComment(commentRequestDTO, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<TodosResponseDTO> putComment(@PathVariable Long commentId, @RequestBody CommentRequestDTO commentRequestDTO, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        CommentResponseDTO responseDTO = commentService.updateComment(commentId, commentRequestDTO, userDetails.getUser());
        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<TodosResponseDTO> deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.deleteComment(commentId, userDetails.getUser());
        return ResponseEntity.ok().body(new TodosResponseDTO("정상적으로 삭제 되었습니다.", HttpStatus.OK.value()));
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
