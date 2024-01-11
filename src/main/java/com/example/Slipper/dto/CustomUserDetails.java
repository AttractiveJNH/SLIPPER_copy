package com.example.Slipper.dto;

import com.example.Slipper.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 유저 권한 및 로그인 아이디, 패스워드 확인 DTO
public class CustomUserDetails implements UserDetails {
    
    private UserEntity userEntity;
    
    //User 객체 불러오기.
    public CustomUserDetails(UserEntity userEntity){
        this.userEntity = userEntity;
    }
    
    //유저 권한 확인 및 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        Collection<GrantedAuthority> collection = new ArrayList<>();
        
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userEntity.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return userEntity.getUserPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUserId();
    }


    // 이하 값들은 따로 엔티티에 따로 구현할 칼럼 하나씩은 있어야 함. 강제적으로 true 설정.

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
