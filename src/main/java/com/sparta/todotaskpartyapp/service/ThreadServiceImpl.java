package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;
import com.sparta.todotaskpartyapp.entity.Thread;
import com.sparta.todotaskpartyapp.repository.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService {

    private final ThreadRepository threadRepository;

    public List<Thread> searchThreads(ThreadResponseDTO searchDTO) {
        return threadRepository.search(searchDTO);
    }
}
