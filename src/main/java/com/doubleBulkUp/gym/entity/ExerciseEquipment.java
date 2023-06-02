package com.doubleBulkUp.gym.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class ExerciseEquipment {
    @Id
    private String equipmentName;

    private String exercisePart;
}
