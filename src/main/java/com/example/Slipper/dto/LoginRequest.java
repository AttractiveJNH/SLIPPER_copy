package com.example.Slipper.dto;

//유저 로그인 폼

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

    private String loginId;

    private String password;

    private String userType;


    

}
