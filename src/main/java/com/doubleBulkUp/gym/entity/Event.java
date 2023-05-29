package com.doubleBulkUp.gym.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    private Long eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gym gym;

    private LocalDateTime eventDateTime;
    private String eventName;
    private String eventCondition; //참여 조건
    private String eventDescription;
}
