package com.doubleBulkUp.gym.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
public class Event implements Serializable {

    @Id
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "gymName")
    private Gym gym;

    private LocalDateTime eventDateTime;
    private String eventCondition;
    private String eventDiscript;
}
