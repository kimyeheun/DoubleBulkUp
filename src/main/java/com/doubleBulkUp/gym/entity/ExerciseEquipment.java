package com.doubleBulkUp.gym.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class ExerciseEquipment {
    @Id
    @Column(name = "equipmentName")
    private String equipmentName;

    @Column(name="exercisePart")
    private String exercisePart;
}
