package com.doubleBulkUp.user.entity;

import javax.persistence.*;

@Entity
@Table(name = "Trainer")
public class Trainer{
    @Id
    private String trainerId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "trainerId")
    private Person person;

    @Column(name = "trainerWorkTime")
    private String trainerWorkTime;
    @Column(name = "trainerCertificate")
    private String trainerCertificate;
    @Column(name = "trainerPrize")
    private String trainerPrize;
}
