package com.doubleBulkUp.User.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSignupResponseDto {
    private String userId;
    private String username;
}
