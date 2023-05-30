package com.doubleBulkUp.user.entity;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class User extends Person{
    private String userAddress;
    private Double userHeight;
    private Double userWeight;

    @Enumerated(EnumType.STRING)
    private Purpose purpose;

}
