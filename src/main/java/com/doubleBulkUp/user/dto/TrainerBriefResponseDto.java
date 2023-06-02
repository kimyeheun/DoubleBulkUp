package com.doubleBulkUp.user.dto;

import com.doubleBulkUp.user.entity.Gender;
import com.doubleBulkUp.user.entity.Person;
import com.doubleBulkUp.user.entity.Trainer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainerBriefResponseDto {
    private String id;
    private String userName;
    private Gender gender;
    private LocalDate userBirth;
    private String userEmail;
    private String userPhone;
    private String gymName;
    private String trainerWorkTime;

    public TrainerBriefResponseDto(Trainer trainer) {
        id = trainer.getPerson().getId();
        userName = trainer.getPerson().getUserName();
        gender = trainer.getPerson().getGender();
        userBirth = trainer.getPerson().getUserBirth();
        userEmail = trainer.getPerson().getUserEmail();
        userPhone = trainer.getPerson().getUserPhone();
        gymName = trainer.getGymName().getGymName();
        trainerWorkTime = trainer.getTrainerWorkTime();
    }
}
