package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, String> {
}
