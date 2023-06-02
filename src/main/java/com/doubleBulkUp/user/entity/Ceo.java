package com.doubleBulkUp.user.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="Ceo")
public class Ceo {
    @Id
    private String ceoId;

    @OneToOne
    @JoinColumn(name = "ceoId", referencedColumnName = "personId")
    private Person person;

    @Column(name = "ceoRegistrationNum")
    private String ceoRegistrationNum;
    @Column(name = "gymName")
    private String gymName;
}
