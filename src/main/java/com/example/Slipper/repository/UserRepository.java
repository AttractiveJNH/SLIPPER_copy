package com.example.Slipper.repository;

import com.example.Slipper.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // userID가 중복하는가
    boolean existsById(String id);

    // nickName이 중복하는가
    boolean existsByUserNickName(String userNickName);

    // id로 유저 정보 찾기
   Optional<UserEntity> findById(String id);

   UserEntity findByUserNum(Long userNum);


}
