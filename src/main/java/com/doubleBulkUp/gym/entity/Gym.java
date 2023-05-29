package com.doubleBulkUp.gym.entity;

import com.doubleBulkUp.User.entity.Ceo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Gym {
    @Id
    private String gymName;

    private String gymLocation;
    private Integer gymPeople;
    private Long gymPrice;
    private String gymUsableTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ceo ceo;
}
