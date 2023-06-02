package com.doubleBulkUp.review.dto;

import com.doubleBulkUp.review.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardBriefResponseDto {
    private Integer boardId;
    private String boardTitle;
    private String boardContent;
    private Integer boardLike;
    private String userName;

    public BoardBriefResponseDto(Board board){
        boardId = board.getBoardId();
        boardTitle = board.getBoardTitle();
        boardContent = board.getBoardContent();
        boardLike = board.getBoardLike();
        userName = board.getUser().getUserId();;
    }
}
