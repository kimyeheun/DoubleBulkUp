package com.doubleBulkUp.user.dto;


import com.doubleBulkUp.user.entity.Ceo;
import com.doubleBulkUp.user.entity.Gender;
import com.doubleBulkUp.user.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CeoDetailResponseDto {
    private String id;
    private String userName;
    private LocalDate userBirth;
    private String userEmail;
    private String userPhone;
    private Gender gender;
    private String ceoRegistrationNum;
    private String gymName;

    //todo: 트레이너 리스트, 헬스장 이벤트 리스트
    public CeoDetailResponseDto(Ceo ceo, Person person){
        id = ceo.getCeoId();
        userName = person.getUserName();
        userBirth = person.getUserBirth();
        userEmail = person.getUserEmail();
        userPhone = person.getUserPhone();
        gender = person.getGender();
        ceoRegistrationNum = ceo.getCeoRegistrationNum();
        gymName = ceo.getGymName();
    }
}
