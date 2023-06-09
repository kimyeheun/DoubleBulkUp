package com.doubleBulkUp.gym.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipmentDto {
    String gymName;
    String listName;

    public EquipmentDto(String gymName) {
        this.gymName = gymName;
    }
}
