package com.doubleBulkUp.review.repository;

import com.doubleBulkUp.review.entity.Board;
import com.doubleBulkUp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByUser(User user);
    Boolean existsByUser(User user);
    List<Board> findByBoardTitleContaining(String keyword);
}
