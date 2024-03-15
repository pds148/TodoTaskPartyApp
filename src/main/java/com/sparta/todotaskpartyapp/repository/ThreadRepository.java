package com.sparta.todotaskpartyapp.repository;

import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;
import com.sparta.todotaskpartyapp.entity.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThreadRepository extends JpaRepository<Thread, Long> {
    List<Thread> search(ThreadResponseDTO searchDTO);

    Page<Thread> searchWithPagination(ThreadResponseDTO searchDTO, Pageable pageable);
}
