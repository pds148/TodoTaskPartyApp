package com.sparta.todotaskpartyapp.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;
import com.sparta.todotaskpartyapp.entity.QThread;
import com.sparta.todotaskpartyapp.entity.Thread;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ThreadRepositoryImpl implements ThreadRepositoryCustom {
    private final EntityManager entityManager;

    public List<Thread> search(ThreadResponseDTO searchDTO) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        return queryFactory.selectFrom(QThread.thread)
                .where(QThread.thread.title.containsIgnoreCase(searchDTO.getTitle())
                        .or(QThread.thread.content.containsIgnoreCase(searchDTO.getTitle())))
                .fetch();
    }

    public Page<Thread> searchWithPagination(ThreadResponseDTO searchDTO, Pageable pageable) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        var query = queryFactory.selectFrom(QThread.thread)
                .where(QThread.thread.title.containsIgnoreCase(searchDTO.getTitle())
                        .or(QThread.thread.content.containsIgnoreCase(searchDTO.getTitle())));

        List<Thread> threads = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = query.fetchCount();
        return new PageImpl<>(threads, pageable, total);
    }
}
