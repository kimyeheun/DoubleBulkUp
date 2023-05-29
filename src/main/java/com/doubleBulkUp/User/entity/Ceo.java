package com.doubleBulkUp.User.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Ceo extends Person{
    private String ceoRegistrationNum; //사업자 등록 번호
    private String gymName;
}
