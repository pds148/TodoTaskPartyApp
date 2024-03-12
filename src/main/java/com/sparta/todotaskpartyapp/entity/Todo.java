package com.sparta.todotaskpartyapp.entity;

import com.sparta.todotaskpartyapp.dto.request.TodoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "todo")
public class Todo extends Timestamped implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private String todoTitle;

    @Getter
    @Column(nullable = false)
    private String todoContent;

    @Column(nullable = false)
    private boolean complete;

    @Column(nullable = false)
    private Boolean isCompleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "todo")
    private List<Comment> comments;

    @OneToMany(mappedBy = "todo")
    private List<TodoComment> todoCommentList = new ArrayList<>();

    @Builder
    public Todo(String todoTitle, String todoContent) {
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }

    public Todo(TodoRequestDTO requestDTO) {
        this.todoTitle = requestDTO.getTodoTitle();
        this.todoContent = requestDTO.getTodoContent();
    }

    // 연관관계 메서드
    public void setUser(User user) {
        this.user = user;
    }

    // 서비스 메서드
    public void setTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public void setContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public void setIsCompleted() {
        this.isCompleted = false;
    }

    public void complete() {
        this.complete = false;
    }
}

