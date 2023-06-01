package com.doubleBulkUp.gym.dto;

import com.doubleBulkUp.gym.entity.Gym;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GymListResponseDto {
    private String gymName;
    private String gymLocation;
    private Integer gymPeople;
    private Long gymPrice;
    private String gymUsableTime;
    private String ceoId;

    public GymListResponseDto(Gym gym){
        this.gymName = gym.getGymName();
        this.gymLocation = gym.getGymLocation();
        this.gymPeople = gym.getGymPeople();
        this.gymPrice = gym.getGymPrice();
        this.gymUsableTime = gym.getGymUsableTime();
        //todo:변경된 부분

        this.ceoId = gym.getCeo().toString();
    }
}
