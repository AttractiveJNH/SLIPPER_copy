package com.example.Slipper.service;

import com.example.Slipper.dto.UserDto;
import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JoinService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    // User 회원 가입 메서드
    public void userJoinProcess(UserDto userDto) {


        UserEntity userEntityData = new UserEntity();
        userEntityData.setUserId(userDto.getUserId());
        userEntityData.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
        userEntityData.setUserBirthDate(userDto.getUserBirthDate());
        userEntityData.setUserName(userDto.getUserName());
        userEntityData.setUserLocation(userDto.getUserLocation());
        userEntityData.setUserPhone(userDto.getUserPhone());
        userEntityData.setUserNickName(userDto.getUserNickName());
        userEntityData.setRole("USER");

        userRepository.save(userEntityData);
    }
}
