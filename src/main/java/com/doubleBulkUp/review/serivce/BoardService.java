package com.doubleBulkUp.review.serivce;

import com.doubleBulkUp.review.dto.BoardBriefResponseDto;
import com.doubleBulkUp.review.dto.BoardDetailResponseDto;
import com.doubleBulkUp.review.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    public List<BoardBriefResponseDto> findAll(){
        return boardRepository.findAll()
                .stream()
                .map(BoardBriefResponseDto::new)
                .collect(Collectors.toList());
    }

    public BoardDetailResponseDto findById(Integer boardId) {
        return boardRepository.findById(boardId)
                .map(BoardDetailResponseDto::new)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
