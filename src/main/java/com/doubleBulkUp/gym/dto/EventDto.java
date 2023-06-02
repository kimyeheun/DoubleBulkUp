package com.doubleBulkUp.gym.dto;

import com.doubleBulkUp.gym.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private String eventName;
    private String gymName;

    private LocalDateTime eventDateTime;
    private String eventCondition;
    private String eventDiscript;

    public EventDto(Event event){
        eventName = event.getEventName();
        gymName = event.getGym().getGymName();
        eventDateTime = event.getEventDateTime();
        eventCondition = event.getEventCondition();
        eventDiscript = event.getEventDiscript();
    }
}
