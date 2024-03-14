package com.sparta.todotaskpartyapp.service;

import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;

import java.util.List;

public interface ThreadService {
    List<ThreadResponseDTO> searchThreads(ThreadResponseDTO searchDTO);
}
