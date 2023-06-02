package com.doubleBulkUp.gym.dto;

import com.doubleBulkUp.gym.entity.ExerciseEquipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseEquipmentDto {
    private String equipmentName;
    private String exercisePart;
    private List<ExerciseSupplementDto> exerciseSupplements = new ArrayList<>();

    public ExerciseEquipmentDto(ExerciseEquipment ee){
        this.equipmentName = ee.getEquipmentName();
        this.exercisePart = ee.getExercisePart();
    }
}
