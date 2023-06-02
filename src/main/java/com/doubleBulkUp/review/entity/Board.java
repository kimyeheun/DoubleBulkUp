package com.doubleBulkUp.review.entity;

import com.doubleBulkUp.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Board {
    @Id
    @Column(name = "boardNumber")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId;

    private String boardTitle;
    private LocalDateTime createdDate;
    private String boardContent;
    private Integer boardLike;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
