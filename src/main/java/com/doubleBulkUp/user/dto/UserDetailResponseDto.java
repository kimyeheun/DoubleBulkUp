package com.doubleBulkUp.user.dto;

import com.doubleBulkUp.user.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class UserDetailResponseDto {
    private String id;
    private String userName;

    private LocalDate userBirth;
    private String userEmail;
    private String userPhone;

    private Gender gender;
    private String userAddress;
    private Double userHeight;
    private Double userWeight;
}
