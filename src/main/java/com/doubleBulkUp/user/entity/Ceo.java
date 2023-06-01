package com.doubleBulkUp.user.entity;

import javax.persistence.*;

@Entity
@Table(name="Ceo")
public class Ceo {
    @Id
    private String ceoId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "ceoId")
    private Person person;

    @Column(name = "ceoRegistrationNum")
    private String ceoRegistrationNum;
    @Column(name = "gymName")
    private String gymName;
}
