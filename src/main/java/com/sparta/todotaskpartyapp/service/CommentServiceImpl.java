package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.request.CommentRequestDTO;
import com.sparta.todotaskpartyapp.dto.response.CommentResponseDTO;
import com.sparta.todotaskpartyapp.entity.Comment;
import com.sparta.todotaskpartyapp.entity.Todo;
import com.sparta.todotaskpartyapp.entity.User;
import com.sparta.todotaskpartyapp.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TodoServiceImpl todoService;

    public CommentResponseDTO createComment(CommentRequestDTO dto, User user) {
        Todo todo = todoService.getTodoById(dto.getTodoId());

        Comment comment = new Comment(dto);
        comment.setUser(user);
        comment.setTodo(todo);

        commentRepository.save(comment);

        return new CommentResponseDTO(comment);
    }

    @Transactional
    public CommentResponseDTO updateComment(Long commentId, CommentRequestDTO commentRequestDTO, User user) {
        Comment comment = getUserComment(commentId, user);

        comment.setText(commentRequestDTO.getCommentContent());

        return new CommentResponseDTO(comment);
    }

    public void deleteComment(Long commentId, User user) {
        Comment comment = getUserComment(commentId, user);

        commentRepository.delete(comment);
    }

    private Comment getUserComment(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글 ID 입니다."));

        if (!user.getId().equals(comment.getUser().getId())) {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        }
        return comment;
    }
}
