package com.doubleBulkUp.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSignupResponseDto {
    private String userId;
    private String username;
}
