package com.doubleBulkUp.gym.entity;

import javax.persistence.*;

@Entity
public class EEMappingES {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ee_es_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExerciseEquipment exerciseEquipment;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExerciseSupplement exerciseSupplement;
}
