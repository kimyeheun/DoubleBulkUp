package com.doubleBulkUp.review.dto;

import com.doubleBulkUp.review.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDetailResponseDto {
    private Integer boardId;
    private String boardTitle;
    private String boardContent;
    private Integer boardLike;
    private String userName;

    public BoardDetailResponseDto(Board board){
        boardId = board.getBoardNumber();
        boardTitle = board.getBoardTitle();
        boardContent = board.getBoardContent();
        boardLike = board.getBoardLike();
        userName = board.getUser().getUserId();
    }
}
