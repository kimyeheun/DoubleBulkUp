package com.doubleBulkUp.user.dto;

import com.doubleBulkUp.user.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class TrainerDetailResponseDto {
    private String id;
    private String userName;
    private Gender gender;
    private LocalDate userBirth;
    private String userEmail;
    private String userPhone;

    private String gymName;
    private String trainerWorkTime;
}
