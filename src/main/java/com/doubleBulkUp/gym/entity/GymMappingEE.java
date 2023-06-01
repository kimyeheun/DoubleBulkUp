package com.doubleBulkUp.gym.entity;

import javax.persistence.*;

@Entity
public class GymMappingEE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gym_ee_id;

    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gym gym;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExerciseEquipment exerciseEquipment;
}
