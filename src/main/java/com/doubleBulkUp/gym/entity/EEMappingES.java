package com.doubleBulkUp.gym.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity @Getter
public class EEMappingES {

    @Id
    @Column(name = "EEMappingESId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipmentName")
    private ExerciseEquipment exerciseEquipment;

    @ManyToOne
    @JoinColumn(name = "sulpplementName")
    private ExerciseSupplement exerciseSupplement;
}
