package com.doubleBulkUp.review.dto;

import com.doubleBulkUp.review.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardNewDto {
    private String userName;
    private String userPassword;
    private Integer boardId;
    private String boardTitle;
    private String boardContent;

    public BoardNewDto(Board board) {
        this.boardId = board.getBoardNumber();
        this.userName = board.getUser().getUserId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
    }
}
