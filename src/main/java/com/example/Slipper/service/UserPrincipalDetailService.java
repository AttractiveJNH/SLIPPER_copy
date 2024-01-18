package com.example.Slipper.service;

import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//UserDetailService를 구현한 클래스
//스프링 시큐리티가 로그인 요청을 가로챌 때, username, password 2개를 가로채는데 password부분은 알아서 함

@Service
public class UserPrincipalDetailService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        // 넘겨받은 아이디로 디비에서 회원 정보를 찾음
        UserEntity user = userRepository.findByUserId(userId);
        System.out.println("userId: " + userId);
        System.out.println("user: " + user);

        //없을경우 에러 발생
        if(user == null)
            throw new UsernameNotFoundException(userId + "를 찾을 수 없습니다.");


        return new UserPrincipalDetails;
    }
}
