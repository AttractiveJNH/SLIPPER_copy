package com.example.Slipper.service;

import com.example.Slipper.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Spring Security에 있는 UserDetails를 구현한 클래스
//이 클래스를 통해 Spring Securityㅇ서 사용자의 정보를 담아둠
public class UserPrincipalDetails implements UserDetails {

    private final UserEntity user;

    public UserPrincipalDetails(UserEntity user){
        this.user = user;
    }


    // user계정의 권한을 담아두기 위해
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> userRole = new ArrayList<>();
        userRole.add(new SimpleGrantedAuthority(user.getRole()));

        return userRole;
    }

    // user계정의 비밀번호를 담아두기 위해
    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    // user계정의 아이디를 담아두기 위해
    @Override
    public String getUsername() {
        return user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
