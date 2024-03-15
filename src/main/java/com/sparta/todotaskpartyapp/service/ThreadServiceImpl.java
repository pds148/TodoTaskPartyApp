package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;
import com.sparta.todotaskpartyapp.entity.Thread;
import com.sparta.todotaskpartyapp.repository.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService {

    private final ThreadRepository threadRepository;

    @Override
    public List<Thread> searchThreads(ThreadResponseDTO searchDTO) {
        return threadRepository.search(searchDTO);
    }

    @Override
    public Page<Thread> searchThreads(ThreadResponseDTO searchDTO, Pageable pageable) {
        return threadRepository.searchWithPagination(searchDTO, pageable);
    }
}

