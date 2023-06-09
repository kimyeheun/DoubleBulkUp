package com.doubleBulkUp.gym.entity;

import com.doubleBulkUp.user.entity.Ceo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Gym")
public class Gym implements Serializable {
    @Id @Column(name = "gymName")
    private String gymName;

    @Column(name = "gymLocation")
    private String gymLocation;

    @Column(name = "gymPeople")
    private Integer gymPeople;

    @Column(name = "gymPrice")
    private Long gymPrice;

    @Column(name = "gymUseableTime")
    private String gymUsableTime;

    @Column(name="gymPicture")
    private String gymPicture;

    @JoinColumn(name = "ceoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ceo ceo;
}
