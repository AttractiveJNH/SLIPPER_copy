package com.example.Slipper.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @NoArgsConstructor
@Setter
public class User implements UserDetails {
    // UserDetails를 상속받아 인증 객체로 사용

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private Long userNum;

    private String userId;

    private String userPassword;

    private String userName;

    private LocalDate userBirthDate;

    private String userPhone;

    private String userLocation;

    private String userNickName;

    @Builder
    public User(String userId, String userPassword,String auth){
        this.userId = userId;
        this.userPassword = userPassword;

    }


   // 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    // 사용자의 패스워드 반환
    @Override
    public String getPassword() {
        return userPassword;
    }

    // 사용자의 id를 반환 ( 고유한 값 )
    @Override
    public String getUsername() {
        return userId;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        //만료 되었는지 확인하는 로직
        return true; // true - 만료되지 않았음
    }

    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        //잠금 되었는지 확인하는 로직
        return true; // true - 잠기지 않음
    }

    // 패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드가 만료되었는지 확인
        return true; // true - 만료되지 않았음
    }

    // 계정 사용 가능여부 반환
    @Override
    public boolean isEnabled() {
        // 계정이 사용 가능한지 확인하는 로직
        return true; // true - 사용 가능
    }
}
