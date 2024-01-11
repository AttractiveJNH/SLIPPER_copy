package com.example.Slipper.service;

import com.example.Slipper.dto.EntreDto;
import com.example.Slipper.dto.UserDto;
import com.example.Slipper.entity.EntreEntity;
import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.EntreRepository;
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
    EntreRepository entreRepository;

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


    //사업자 회원가입
    public void entreJoinProcess(EntreDto entreDto) {


        EntreEntity entreEntityData = new EntreEntity();
        entreEntityData.setEntrepreId(entreDto.getEntrepreId());
        entreEntityData.setEntreprePassword(passwordEncoder.encode(entreDto.getEntreprePassword()));
        entreEntityData.setEntrepreName(entreDto.getEntrepreName());
        entreEntityData.setEntrepreLocation(entreDto.getEntrepreLocation());
        entreEntityData.setEntreprePhone(entreDto.getEntreprePhone());
        entreEntityData.setEntrepreNickName(entreDto.getEntrepreNickName());
        entreEntityData.setEntrepreRegNum(entreDto.getEntrepreRegNum());
        entreEntityData.setEntrepreRegDay(entreDto.getEntrepreRegDay());
        entreEntityData.setEntrepreBusinessName(entreDto.getEntrepreBusinessName());
        entreEntityData.setEntrepreAddress(entreDto.getEntrepreAddress());
        entreEntityData.setRole("ENTREPRENEUR");

        entreRepository.save(entreEntityData);
    }
}
