package com.doubleBulkUp.user.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class UserMappingTrainer {
    @Id @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trainerId")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
