package com.doubleBulkUp.gym.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
public class Event implements Serializable {

    @Id
    @Column(name = "eventName")
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "gymName")
    private Gym gym;

    @Column(name="eventDateTime")
    private LocalDateTime eventDateTime;
    @Column(name="eventCondition")
    private String eventCondition;
    @Column(name="eventDiscript")
    private String eventDiscript;
}
