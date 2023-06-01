package com.doubleBulkUp.gym.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExerciseEquipment {
    @Id
    private String equipmentName;

    private String exercisePart;
}
