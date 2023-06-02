package com.doubleBulkUp.review.controller;

import com.doubleBulkUp.review.serivce.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String boardList(Model model){
        model.addAttribute("boards", boardService.findAll());
        return "board/boardList";
    }

    @GetMapping("/{boardId}")
    public String boardDetail(
            @PathVariable Integer boardId,
            Model model
    ){
        model.addAttribute("board", boardService.findById(boardId));
        return "board/boardDetail";
    }
}
