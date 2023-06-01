package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.ExerciseEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseEquipmentRepository extends JpaRepository<ExerciseEquipment, String> {
}
