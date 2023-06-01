package com.doubleBulkUp.user.dto;

import com.doubleBulkUp.user.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class TrainerSignupRequestDto {
    private String trainerId;
    private String password;
    private String trainerName;
    private Gender gender;
    private String trainerEmail;
    private LocalDate trainerBirth;
    private String trainerPhone;
    private String gymName;
}
