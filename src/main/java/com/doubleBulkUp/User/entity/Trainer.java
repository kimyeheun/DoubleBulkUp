package com.doubleBulkUp.User.entity;

//import com.example.demo.gym.entity.Gym;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer extends Person{
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Gym gymName;

    private String trainerWorkTime;
    private String trainerCertificate;
    private String trainerPrize;
}
