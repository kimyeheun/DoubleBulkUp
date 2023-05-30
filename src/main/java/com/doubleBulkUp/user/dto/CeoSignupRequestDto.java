package com.doubleBulkUp.user.dto;

import com.doubleBulkUp.user.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CeoSignupRequestDto {
    private String ceoId;
    private String password;
    private String ceoName;
    private Gender gender;
    private String ceoEmail;
    private LocalDate ceoBirth;
    private String ceoPhone;
    private String registerNumber;
    private String gymName;
}
