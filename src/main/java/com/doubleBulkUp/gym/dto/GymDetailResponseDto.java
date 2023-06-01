package com.doubleBulkUp.gym.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GymDetailResponseDto {
    private String gymName;
    private String gymLocation;
    private Integer gymPeople;
    private Long gymPrice;
    private String gymUsableTime;
    private String ceoId;
    private Integer showerBoothCnt;
    private Boolean fittingRoom;
    private Boolean clothes;
    private Integer lockerCnt;
    private String howToAttendance;
}
