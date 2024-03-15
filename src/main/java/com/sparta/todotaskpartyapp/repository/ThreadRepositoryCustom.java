package com.sparta.todotaskpartyapp.repository;

import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;
import com.sparta.todotaskpartyapp.entity.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ThreadRepositoryCustom {
    List<Thread> search(ThreadResponseDTO searchDTO);
    Page<Thread> searchWithPagination(ThreadResponseDTO searchDTO, Pageable pageable);
}
