package com.doubleBulkUp.review.serivce;

import com.doubleBulkUp.review.dto.BoardBriefResponseDto;
import com.doubleBulkUp.review.dto.BoardDetailResponseDto;
import com.doubleBulkUp.review.dto.BoardNewDto;
import com.doubleBulkUp.review.entity.Board;
import com.doubleBulkUp.review.repository.BoardRepository;
import com.doubleBulkUp.user.entity.User;
import com.doubleBulkUp.user.repository.PersonRepository;
import com.doubleBulkUp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public List<BoardBriefResponseDto> findAll(){
        return boardRepository.findAll()
                .stream()
                .map(BoardBriefResponseDto::new)
                .collect(Collectors.toList());
    }
    public List<BoardBriefResponseDto> search(String keyword) {
        return boardRepository.findByBoardTitleContaining(keyword)
                .stream()
                .map(BoardBriefResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<BoardBriefResponseDto> findMyAll(String personId) {
        User user = userRepository.findById(personId).get();
        return boardRepository.findByUser(user)
                .stream()
                .map(BoardBriefResponseDto::new)
                .collect(Collectors.toList());
    }

    public BoardDetailResponseDto findById(Integer boardId) {
        return boardRepository.findById(boardId)
                .map(BoardDetailResponseDto::new)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public boolean createBoard(BoardNewDto boardNewDto) {
        Board board = new Board();
        User user = userRepository.findById(boardNewDto.getUserName()).get();
        if(!check(boardNewDto.getUserName(), boardNewDto.getUserPassword()))
            return false;

        board.setUser(user);
        board.setBoardTitle(boardNewDto.getBoardTitle());
        board.setBoardContent(boardNewDto.getBoardContent());
        board.setCreatedDate(LocalDateTime.now());
        boardRepository.save(board);

        return boardRepository.existsByUser(user);
    }

    public BoardNewDto updateBoardSet(Integer boardId) {
        System.out.println(boardId);
        return boardRepository.findById(boardId)
                .map(BoardNewDto::new)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public boolean updateBoard(Integer boardId, BoardNewDto boardNewDto) {
        System.out.println("hihih" + boardId);
        System.out.println("USerName"+boardNewDto.getUserName());

        Board board = boardRepository.findById(boardId).get();
        System.out.println("Title"+board.getBoardTitle());

        User user = userRepository.findById(boardNewDto.getUserName()).get();

        if(!check(board.getUser().getUserId(), boardNewDto.getUserPassword()))
            return false;

        board.setBoardTitle(boardNewDto.getBoardTitle());
        board.setBoardContent(boardNewDto.getBoardContent());
        boardRepository.save(board);

        return boardRepository.existsByUser(user);
    }

    private boolean check(String userName, String userPassword) {
        String personPassword = personRepository.findById(userName).get().getUserPassword();
        return personPassword.equals(userPassword);
    }

    public boolean checkPassword(String personId, Integer boardId) {
        String personPassword = personRepository.findById(personId).get().getUserPassword();
        User user = boardRepository.findById(boardId).get().getUser();
        String boardIdPassword = personRepository.findById(user.getUserId()).get().getUserPassword();

        return personPassword.equals(boardIdPassword);
    }

    public void deleteBoard(Integer boardId) {
        boardRepository.deleteById(boardId);
    }

}
