package com.doubleBulkUp.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "User")
public class User {
    @Id
    private String userId;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "personId")
    private Person person;

    @Column(name = "userAddress")
    private String userAddress;
    @Column(name = "userHeight")
    private Double userHeight;
    @Column(name = "userWeight")
    private Double userWeight;

    @Enumerated(EnumType.STRING)
    @Column(name = "Perpose") // DB에서 오타난 부분
    private Purpose purpose;

}
