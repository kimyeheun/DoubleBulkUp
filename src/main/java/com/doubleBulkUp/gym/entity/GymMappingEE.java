package com.doubleBulkUp.gym.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "EEMappingGym")
public class GymMappingEE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @JoinColumn(name = "gymName")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gym gym;

    @JoinColumn(name = "equipmentName")
    @ManyToOne(fetch = FetchType.LAZY)
    private ExerciseEquipment exerciseEquipment;
}
