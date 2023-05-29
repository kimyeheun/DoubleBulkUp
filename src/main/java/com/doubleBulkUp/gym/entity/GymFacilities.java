package com.doubleBulkUp.gym.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GymFacilities {
    @Id
    private Long gymFacilitiesId;

    @OneToOne
    private Gym gym;

    private Integer showerBoothCnt;
    private Boolean fittingRoom;
    private Boolean clothes;
    private Integer lockerCnt;
    private String howToAttendance;
}

