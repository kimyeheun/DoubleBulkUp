package com.doubleBulkUp.user.dto;

import com.doubleBulkUp.user.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserUpdateResponseDto {
    private String id;
    private String userPicture;
    private String userName;
    private LocalDate userBirth;
    private String userEmail;
    private String userPhone;
    private Gender gender;

    private String userAddress;
    private Double userHeight;
    private Double userWeight;

//    public UserUpdateResponseDto(Person person, User user) {
//        this.id = person.getId();
//        this.userPicture = person.getUserPicture();
//        this.userName = person.getUserName();
//        this.userBirth = person.getUserBirth();
//        this.userEmail = person.getUserEmail();
//        this.userPhone = person.getUserPhone();
//        this.gender = person.getGender();
//        this.userAddress = user.getUserAddress();
//        this.userHeight = user.getUserHeight();
//        this.userWeight = user.getUserWeight();
//    }
}
