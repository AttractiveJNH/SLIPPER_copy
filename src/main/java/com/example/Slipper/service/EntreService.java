package com.example.Slipper.service;


import com.example.Slipper.dto.EntreDto;
import com.example.Slipper.entity.EntreEntity;
import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.EntreRepository;
import com.example.Slipper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EntreService {



    private final EntreRepository entreRepository;




    //아이디 중복체크
    /**
     * loginId 중복 체크
     * 회원가입 기능 구현 시 사용
     * 중복되면 true return
     */
    public boolean checkLoginIdDuplicate(String id){

        return entreRepository.existsById(id);

    }

    /**
     * nickname 중복 체크
     * 회원가입 기능 구현 시 사용
     * 중복되면 true return
     */
    public boolean checkNicknameDuplicate(String entrepreNickName) {

        return entreRepository.existsByEntrepreNickName(entrepreNickName);

    }


    public EntreEntity getLoginUserByLoginId(String id) {

        if(id == null) return null;

        Optional<EntreEntity> optionalUser = entreRepository.findById(id);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
}
