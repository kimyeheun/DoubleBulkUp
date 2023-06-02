package com.doubleBulkUp.user.repository;

import com.doubleBulkUp.user.entity.User;
import com.doubleBulkUp.user.entity.UserMappingTrainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMappingTrainerRepository extends JpaRepository<UserMappingTrainer, Integer> {

    List<UserMappingTrainer> findByUser(User user);
}
