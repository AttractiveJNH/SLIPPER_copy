package com.example.Slipper.service;


import com.example.Slipper.dto.LoginRequest;
import com.example.Slipper.entity.EntreEntity;
import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {



    private final UserRepository userRepository;




    //아이디 중복체크
    /**
     * loginId 중복 체크
     * 회원가입 기능 구현 시 사용
     * 중복되면 true return
     */
    public boolean checkLoginIdDuplicate(String id){

        return userRepository.existsById(id);

    }

    /**
     * nickname 중복 체크
     * 회원가입 기능 구현 시 사용
     * 중복되면 true return
     */
    public boolean checkNicknameDuplicate(String userNickName) {

        return userRepository.existsByUserNickName(userNickName);

    }

    public boolean checkIdExist(String id){

        return userRepository.existsById(id);
    }


//    public UserEntity getLoginUserByLoginId(String id) {
//
//        if(id == null) return null;
//
//        Optional<UserEntity> optionalUser = userRepository.findById(id);
//        if(optionalUser.isEmpty()) return null;
//
//        return optionalUser.get();
//    }

    /**
     *  로그인 기능
     *  화면에서 LoginRequest(loginId, password)을 입력받아 loginId와 password가 일치하면 User return
     *  loginId가 존재하지 않거나 password가 일치하지 않으면 null return
     */
    public UserEntity login(LoginRequest req) {
        Optional<UserEntity> optionalUser = userRepository.findById(req.getLoginId());

        // loginId와 일치하는 User가 없으면 null return
        if(optionalUser.isEmpty()) {
            return null;
        }

        UserEntity user = optionalUser.get();

        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if(!user.getPassword().equals(req.getPassword())) {
            return null;
        }

        return user;
    }



    /**
     * userId(Long)를 입력받아 User을 return 해주는 기능
     * 인증, 인가 시 사용
     * userId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
     * userId로 찾아온 User가 존재하면 User return
     */
    public UserEntity getLoginUserById(Long userId) {
        if(userId == null) return null;

        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }


}
