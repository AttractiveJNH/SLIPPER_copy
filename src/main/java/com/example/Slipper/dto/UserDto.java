package com.example.Slipper.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class UserDto {
    private Long userNum;

    private String userId;

    private String userPassword;

    private String userName;

    private LocalDate userBirthDate;

    private Integer userPhone;

    private String userLocation;

    private String userNickName;
}
