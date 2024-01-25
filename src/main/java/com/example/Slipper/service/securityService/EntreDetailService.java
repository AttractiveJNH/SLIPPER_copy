package com.example.Slipper.service.securityService;

import com.example.Slipper.entity.EntreEntity;
import com.example.Slipper.repository.EntreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntreDetailService implements UserDetailsService {

    @Autowired
    EntreRepository entreRepository;

    // 로그인 할때 사용자 정보를 가져오는 코드.
    @Override
    public UserDetails loadUserByUsername(String entreId) throws UsernameNotFoundException {

        EntreEntity entre = entreRepository.findByEntrepreId(entreId)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
                });
        return new EntrePrincipalDetails(entre);
    }
}