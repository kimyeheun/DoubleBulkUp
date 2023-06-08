package com.doubleBulkUp.review.entity;

import com.doubleBulkUp.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Board {
    @Id
    @Column(name = "boardNumber", columnDefinition = "INT default 31")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNumber;

    private String boardTitle;
    private LocalDateTime createdDate;
    private String boardContent;
    private Integer boardLike;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @PrePersist
    public void setBoardLike() {
        this.boardLike = 0;
    }
}
