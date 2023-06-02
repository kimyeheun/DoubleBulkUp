package com.doubleBulkUp.gym.dto;

import com.doubleBulkUp.user.dto.TrainerBriefResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private String image;
    private List<ExerciseEquipmentDto> exerciseEquipments;
    private final List<EventDto> events = new ArrayList<>();
    private final List<TrainerBriefResponseDto> trainers = new ArrayList<>();
    public GymDetailResponseDto(){
        this.exerciseEquipments = new ArrayList<>();
    }
}
