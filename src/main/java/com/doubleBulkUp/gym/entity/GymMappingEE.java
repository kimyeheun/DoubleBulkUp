package com.doubleBulkUp.gym.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "EEMappingGym")
public class GymMappingEE {

    @Id
    @Column(name="id", columnDefinition = "INT default 41")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count")
    private Integer count;

    @JoinColumn(name = "gymName")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gym gym;

    @JoinColumn(name = "equipmentName")
    @ManyToOne(fetch = FetchType.LAZY)
    private ExerciseEquipment exerciseEquipment;
}
