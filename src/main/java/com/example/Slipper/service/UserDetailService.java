package com.example.Slipper.service;

import com.example.Slipper.entity.User;
import com.example.Slipper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
// 스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스
public class UserDetailService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    // 사용자 아이디(userId)로 사용자의 정보를 가져오는 메서드
    @Override
    public User loadUserByUsername(String userId){
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException(userId));
    }
}
