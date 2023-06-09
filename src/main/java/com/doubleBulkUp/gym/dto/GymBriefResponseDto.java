package com.doubleBulkUp.gym.dto;

import com.doubleBulkUp.gym.entity.Gym;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GymBriefResponseDto {
    private String gymName;
    private String gymLocation;
    private Integer gymPeople;
    private Long gymPrice;
    private String gymUsableTime;
    private String ceoId;
    private String gymPicture;

    public GymBriefResponseDto(Gym gym){
        this.gymName = gym.getGymName();
        this.gymLocation = gym.getGymLocation();
        this.gymPeople = gym.getGymPeople();
        this.gymPrice = gym.getGymPrice();
        this.gymUsableTime = gym.getGymUsableTime();
        this.ceoId = gym.getCeo().getCeoId();
        this.gymPicture = gym.getGymPicture();
    }
}
