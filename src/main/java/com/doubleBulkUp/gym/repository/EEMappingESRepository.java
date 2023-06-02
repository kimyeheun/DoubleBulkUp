package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.EEMappingES;
import com.doubleBulkUp.gym.entity.ExerciseEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EEMappingESRepository extends JpaRepository<EEMappingES, String> {

    public List<EEMappingES> findByExerciseEquipment(ExerciseEquipment ee);
}
