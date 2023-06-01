package com.doubleBulkUp.gym.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "GymFacilities")
public class GymFacilities implements Serializable {

    @EmbeddedId
    private GymFacilitiesId id;

    @Column(name = "showerBoothCnt")
    private Integer showerBoothCnt;

    @Column(name = "fittingRoom")
    private Boolean fittingRoom;

    @Column(name = "clothes")
    private Boolean clothes;

    @Column(name = "lockerCnt")
    private Integer lockerCnt;

    @Column(name = "howToAttendance")
    private String howToAttendance;
}

