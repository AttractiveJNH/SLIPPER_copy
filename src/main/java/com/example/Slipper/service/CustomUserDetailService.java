package com.example.Slipper.service;

import com.example.Slipper.dto.CustomUserDetails;
import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        UserEntity userData = userRepository.findByUserId(userId);

        if (userData != null){

            //Id가 null이 아니면 로그인을 진행한다.
            return new CustomUserDetails(userData);
        }

        return null;
    }
}
