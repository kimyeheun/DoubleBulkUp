package com.doubleBulkUp.User.entity;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String value;

    Gender(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Gender of(String name){
        for (Gender gender : Gender.values()) {
            if(gender.name().equalsIgnoreCase(name)){
                return gender;
            }
        }
        return null;
    }
}
