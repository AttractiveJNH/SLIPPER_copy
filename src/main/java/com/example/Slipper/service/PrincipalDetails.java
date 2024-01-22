package com.example.Slipper.service;

import com.example.Slipper.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private UserEntity user; // 컴포지션

    public PrincipalDetails(UserEntity user) {
        this.user = user;
    }

    // 해당 유저의 권한을 리턴하는 곳!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();

        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserId();
    }

    // 니 계정 만료되지는 않았니?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 니 계정 잠겨있지 않니?
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 니 계정 비밀번호 갈아낄때 되지 않았니?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 니 계정이 활성화 되어있니?
    @Override
    public boolean isEnabled() {
        // 우리 사이트에서 1년동안 로그인을 안하면 휴면 계정으로 변환하기로 했다면?
        // 현재 시간 - 마지막 로그인 시간으로 계산 => 1년 초과하면 false 로 return.
        // 나머지 비어있는 함수들도 다 비슷하게 구현해주면 된다.
        return true;
    }
}