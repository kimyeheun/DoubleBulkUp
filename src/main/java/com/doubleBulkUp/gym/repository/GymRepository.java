package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymRepository extends JpaRepository<Gym, String> {
}
