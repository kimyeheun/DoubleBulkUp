package com.doubleBulkUp.gym.dto;

import com.doubleBulkUp.gym.entity.Event;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventBriefResponseDto {
    private String eventName;
    private String gym;
    private LocalDateTime eventDateTime;
    private String eventCondition;
    private String eventDiscript;

    public EventBriefResponseDto(Event event) {
        this.eventName = event.getEventName();
        this.gym = event.getGym().getGymName();
        this.eventDateTime = event.getEventDateTime();
        this.eventCondition = event.getEventCondition();
        this.eventDiscript = event.getEventDiscript();
    }
}
