package com.doubleBulkUp.user.repository;

import com.doubleBulkUp.gym.entity.Gym;
import com.doubleBulkUp.user.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, String> {

    List<Trainer> findByGymName(Gym gymName);
}