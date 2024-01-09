package com.example.Slipper.dto;

import com.example.Slipper.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter

public class UserDto {
    private User user;

    private Long userNum;

    private String userId;

    private String userPassword;

    private String userName;

    private LocalDate userBirthDate;

    private String userPhone;

    private String userLocation;

    private String userNickName;
}
