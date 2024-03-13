package com.sparta.todotaskpartyapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "api_task_manager")
public class ApiTaskManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Long totalTime;

    public ApiTaskManager(User user, Long totalTime) {
        this.user = user;
        this.totalTime = totalTime;
    }

    public void addTaskManager(long runTime) {
        this.totalTime += runTime;
    }
}
