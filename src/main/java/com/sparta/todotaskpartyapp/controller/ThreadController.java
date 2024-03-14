package com.sparta.todotaskpartyapp.controller;

import com.sparta.todotaskpartyapp.dto.response.ThreadResponseDTO;
import com.sparta.todotaskpartyapp.entity.Thread;
import com.sparta.todotaskpartyapp.service.ThreadService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/threads")
@AllArgsConstructor
public class ThreadController {

    private final ThreadService threadService;

    @GetMapping("/search")
    public List<Thread> searchThreads(@RequestParam("threadId") Long threadId, @RequestParam("keyword") String keyword) {
        ThreadResponseDTO searchDTO = new ThreadResponseDTO(threadId, keyword);
        return threadService.searchThreads(searchDTO);
    }

    @GetMapping("/search-paginated")
    public ResponseEntity<Page<Thread>> searchThreadsPaginated(@RequestParam("threadId") Long threadId,
                                                               @RequestParam("keyword") String keyword,
                                                               @RequestParam("page") int page,
                                                               @RequestParam("size") int size,
                                                               @RequestParam("sort") String[] sort) {
        ThreadResponseDTO searchDTO = new ThreadResponseDTO(threadId, keyword);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Thread> threads = threadService.searchThreads(searchDTO, pageable);
        return ResponseEntity.ok(threads);
    }
}
