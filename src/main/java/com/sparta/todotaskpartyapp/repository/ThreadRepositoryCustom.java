package com.sparta.todotaskpartyapp.repository;

import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;
import com.sparta.todotaskpartyapp.entity.Thread;

import java.util.List;

public interface ThreadRepositoryCustom {
    List<Thread> search(ThreadResponseDTO searchDTO);
}
