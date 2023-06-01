package com.doubleBulkUp.user.repository;

import com.doubleBulkUp.user.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, String> {

}