package com.doubleBulkUp.review.controller;

import com.doubleBulkUp.review.dto.BoardNewDto;
import com.doubleBulkUp.review.entity.Board;
import com.doubleBulkUp.review.serivce.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시판 리스트
     */
    @GetMapping
    public String boardList(Model model){
        model.addAttribute("boards", boardService.findAll());
        return "board/boardList";
    }
    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {
        model.addAttribute("boards", boardService.search(keyword));
        return "board/boardList";
    }

    // 내 게시글
    @GetMapping("/my/{personId}")
    public String myBoardList(@PathVariable String personId, Model model){
        model.addAttribute("boards", boardService.findMyAll(personId));
        return "board/boardList";
    }

    /**
     * 게시글 삭제
     */
    @GetMapping("/delete/{boardId}")
    public String boardDelete(
            @PathVariable Integer boardId
    ) {
        boardService.deleteBoard(boardId);
        return "redirect:/board";
    }

    /**
     * 게시글 보여주기
     */
    @GetMapping("/{boardId}")
    public String boardDetail(
            @PathVariable Integer boardId,
            Model model
    ){
        model.addAttribute("board", boardService.findById(boardId));
        return "board/boardDetail";
    }
    /**
     * 게시글 수정하기
     */
    @GetMapping("/update/{boardId}")
    public String boardUpdate(
            @PathVariable Integer boardId,
            Model model
    ){
        model.addAttribute("board", boardService.updateBoardSet(boardId));
        return "board/boardUpdate";
    }
    @PostMapping("/update/{boardId}")
    public String boardUpdate(
            @PathVariable Integer boardId,
            BoardNewDto boardNewDto
    ) {
        if(boardService.updateBoard(boardId, boardNewDto))
            return "redirect:/board/" + boardId;
        return "redirect:/board/update/" + boardId;
    }

    /**
     * 새 게시판 생성
     */
    @GetMapping("/new")
    public String createBoard(
            Model model
    ) {
        model.addAttribute("board", new BoardNewDto());
        return "board/boardNew";
    }
    @PostMapping("/new")
    public String createBoard(
            BoardNewDto boardNewDto
    ){
        if(boardService.createBoard(boardNewDto))
            return "redirect:/board";
        return "redirect:/board/new";
    }
}
