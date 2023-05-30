package com.doubleBulkUp.user.entity;

import javax.persistence.Entity;

@Entity
public class Trainer extends Person{
    private String trainerWorkTime;
    private String trainerCertificate;
    private String trainerPrize;
}
