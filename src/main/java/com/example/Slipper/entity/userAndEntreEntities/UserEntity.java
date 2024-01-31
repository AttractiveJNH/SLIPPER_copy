package com.example.Slipper.entity.userAndEntreEntities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @NoArgsConstructor
@Setter
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num")
    private Long userNum; // 유저pk

    @Column(name = "user_id",unique = true, nullable = false)
    private String id; // 유저 아이디

    @Column(name="user_password", nullable = false) // 비밀번호
    private String password;



    @Column(name="user_name", nullable = false)
    private String userName; // 이름

    @Column(name="user_birth_date")
    private LocalDate userBirthDate; // 생일

    @Column(name="user_phone", nullable = false)
    private String userPhone; // 연락처

    @Column(name="user_location", nullable = false)
    private String userLocation; // 지역

    @Column(name="user_nick_name",unique = true)
    private String userNickName; // 닉네임


    private String role; // 역할


//    // 비밀번호 암호화.
//    public void encodingPassword(PasswordEncoder passwordEncoder){
//        if(StringUtils.isEmpty(password)){
//            return;
//        }
//        password = passwordEncoder.encode(password);
//    }



}
