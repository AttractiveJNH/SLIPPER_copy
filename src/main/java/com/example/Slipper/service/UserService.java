package com.example.Slipper.service;

import com.example.Slipper.dto.UserDto;
import com.example.Slipper.entity.User;
import com.example.Slipper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String save(UserDto dto){
        return userRepository.save(User.builder()
                .userId(dto.getUserId())
                //패스워드 암호화
                .userPassword(bCryptPasswordEncoder.encode(dto.getUserPassword()))

                .build()).getUserId();
    }
}
