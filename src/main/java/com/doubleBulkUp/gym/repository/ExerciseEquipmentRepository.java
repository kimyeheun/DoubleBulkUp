package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.ExerciseEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseEquipmentRepository extends JpaRepository<ExerciseEquipment, String> {
    Optional<ExerciseEquipment> findByEquipmentName(String name);
}
