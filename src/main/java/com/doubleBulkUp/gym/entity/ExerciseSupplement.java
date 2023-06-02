package com.doubleBulkUp.gym.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Getter
@Table(name = "ExerciseSupplement")
public class ExerciseSupplement {
    @Id
    @Column(name = "sulpplementName")
    private String supplementName;

    @Column(name = "usePerpose")
    private String usePurpose;
}
