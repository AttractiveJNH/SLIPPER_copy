package com.example.Slipper.service;

import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // 시큐리티 session => Authentication => UserDetails
    // 시큐리티 session(내부 Authentication(UserDetails(PrincipalDetails)))
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserId(userId);

        if(user != null) {
            return new PrincipalDetails(user);
        }
        return null;
    }
}