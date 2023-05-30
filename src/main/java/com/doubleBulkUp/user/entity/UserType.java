package com.doubleBulkUp.user.entity;

import lombok.Getter;

@Getter
public enum UserType {
    User("User"),
    Trainer("Trainer"),
    CEO("CEO");

    private final String value;

    UserType(String value){
        this.value = value;
    }

    public static UserType of(String name){
        for (UserType userType : UserType.values()) {
            if(userType.name().equalsIgnoreCase(name)){
                return userType;
            }
        }
        return null;
    }
}
