package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, String> {
    List<Gym> findByGymLocationContaining(String location);
    Optional<Gym> findByGymName(String gymName);
}
