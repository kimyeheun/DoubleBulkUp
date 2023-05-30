package com.doubleBulkUp.user.entity;

import lombok.Getter;

@Getter
public enum Purpose {
    DIET("DIET"),
    MUSCLE("MUSCLE");

    private final String value;

    Purpose(String value){
        this.value = value;
    }

    public static Purpose of(String name){
        for (Purpose purpose: Purpose.values()) {
            if(purpose.name().equalsIgnoreCase(name)){
                return purpose;
            }
        }
        return null;
    }
}
