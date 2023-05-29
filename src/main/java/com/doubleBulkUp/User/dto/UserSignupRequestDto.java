package com.doubleBulkUp.User.dto;

import com.doubleBulkUp.User.entity.Gender;
import com.doubleBulkUp.User.entity.Purpose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserSignupRequestDto {
    private String userId;
    private String password;
    private String userName;
    private Gender gender;
    private String userEmail;
    private LocalDate userBirth;
    private String userPhone;
    private String userAddress;
    private Double userHeight;
    private Double userWeight;
    private Purpose purpose;
}
