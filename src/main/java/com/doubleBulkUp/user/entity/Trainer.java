package com.doubleBulkUp.user.entity;

import com.doubleBulkUp.gym.entity.Gym;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Trainer")
public class Trainer{
    @Id
    private String trainerId;

    @OneToOne
    @JoinColumn(name = "trainerId", referencedColumnName = "personId")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "gymName")
    private Gym gymName;

    @Column(name = "trainerWorkTime")
    private String trainerWorkTime;
    @Column(name = "trainerCertificate")
    private String trainerCertificate;
    @Column(name = "trainerPrize")
    private String trainerPrize;
}
