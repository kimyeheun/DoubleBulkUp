package com.doubleBulkUp.user.dto;

import com.doubleBulkUp.user.entity.Gender;
import com.doubleBulkUp.user.entity.Person;
import com.doubleBulkUp.user.entity.Purpose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
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
