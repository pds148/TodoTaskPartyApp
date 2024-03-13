package com.sparta.todotaskpartyapp.aop;

import com.sparta.todotaskpartyapp.entity.ApiTaskManager;
import com.sparta.todotaskpartyapp.entity.User;
import com.sparta.todotaskpartyapp.repository.TaskManagerLoggingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class TaskManagerLoggingAop {

    private final TaskManagerLoggingRepository taskManagerLoggingRepository;

    @Pointcut("execution(* com.sparta.todotaskpartyapp.controller.UserController.*(..))")
    private void user() {}

    @Pointcut("execution(* com.sparta.todotaskpartyapp.controller.TodoController.*(..))")
    private void todo() {}

    @Pointcut("execution(* com.sparta.todotaskpartyapp.controller.CommentController.*(..))")
    private void comment() {}

    @Around("user() || todo() || comment()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            log.info("{} 메서드 실행", method.getName());

            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                log.info("타입: {}, 값: {}", arg.getClass().getSimpleName(), arg);
            }

            Object output = joinPoint.proceed();

            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;


            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.getPrincipal() instanceof User) {
                User loginUser = (User) auth.getPrincipal();
                ApiTaskManager apiTaskManager = taskManagerLoggingRepository.findByUser(loginUser).orElse(null);
                if (apiTaskManager == null) {
                    apiTaskManager = new ApiTaskManager(loginUser, runTime);
                } else {
                    apiTaskManager.addTaskManager(runTime);
                }

                log.info("[API 사용 시간] 사용자: {}, 총 시간: {} ms", loginUser.getUsername(), apiTaskManager.getTotalTime());
                taskManagerLoggingRepository.save(apiTaskManager);
            }

            log.info("리턴 객체: {}", output);
            return output;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }

    @AfterReturning(value = "user() || todo() || comment()", returning = "obj")
    public void afterReturn(JoinPoint joinPoint, Object obj) {
        log.info("리턴 객체: {}", obj);
    }
}
