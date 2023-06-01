package com.doubleBulkUp.user.dto;

import com.doubleBulkUp.user.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CeoDetailResponseDto {
    private String id;
    private String userName;
    private LocalDate userBirth;
    private String userEmail;
    private String userPhone;
    private Gender gender;

    //todo: 트레이너 리스트, 헬스장 이벤트 리스트
}
