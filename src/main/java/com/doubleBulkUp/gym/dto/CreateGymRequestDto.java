package com.doubleBulkUp.gym.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateGymRequestDto {
    private String gymName;
    private String gymLocation;
    private Integer gymPeople;
    private Long gymPrice;
    private String gymUsableTime;
    private String ceoId;
}
