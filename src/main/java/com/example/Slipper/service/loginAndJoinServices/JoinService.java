package com.example.Slipper.service.loginAndJoinServices;

import com.example.Slipper.dto.EntreDto;
import com.example.Slipper.dto.UserDto;
import com.example.Slipper.entity.userAndEntreEntities.EntreEntity;
import com.example.Slipper.entity.userAndEntreEntities.UserEntity;
import com.example.Slipper.repository.userAndEntreRepositories.EntreRepository;
import com.example.Slipper.repository.userAndEntreRepositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JoinService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntreRepository entreRepository;




    // User 회원 가입 메서드
    public void userJoinProcess(UserDto userDto) {


        UserEntity user = new UserEntity();



        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setUserBirthDate(userDto.getUserBirthDate());
        user.setUserName(userDto.getUserName());
         user.setUserLocation(userDto.getUserLocation() != null ? userDto.getUserLocation().replace(",","") : null);
        user.setUserPhone(userDto.getUserPhone());
        user.setUserNickName(userDto.getUserNickName());
        user.setRole("USER");

        userRepository.save(user);
    }



    //사업자 회원가입
    public void entreJoinProcess(EntreDto entreDto) {


        EntreEntity entre = new EntreEntity();
        entre.setId(entreDto.getId());
        entre.setPassword(entreDto.getPassword());
        entre.setEntrepreName(entreDto.getEntrepreName());
        entre.setEntrepreLocation(entreDto.getEntrepreLocation() != null ? entreDto.getEntrepreLocation().replace(",","") : null);
        entre.setEntreprePhone(entreDto.getEntreprePhone());
        entre.setEntrepreNickName(entreDto.getEntrepreNickName());
        entre.setEntrepreRegNum(entreDto.getEntrepreRegNum());
        entre.setEntrepreRegDay(entreDto.getEntrepreRegDay());
        entre.setEntrepreBusinessName(entreDto.getEntrepreBusinessName());
        entre.setEntrepreAddress(entreDto.getEntrepreAddress());
        entre.setRole("ENTREPRENEUR");

        entreRepository.save(entre);
    }


}
