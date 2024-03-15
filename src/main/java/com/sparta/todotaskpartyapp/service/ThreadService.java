package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;
import com.sparta.todotaskpartyapp.entity.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ThreadService {
    List<Thread> searchThreads(ThreadResponseDTO searchDTO);
    Page<Thread> searchThreads(ThreadResponseDTO searchDTO, Pageable pageable);
}
