package com.example.Slipper.repository;

import com.example.Slipper.entity.EntreEntity;
import com.example.Slipper.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntreRepository extends JpaRepository<EntreEntity, Long> {

    // userID가 중복하는가
    boolean existsById(String id);

    // nickName이 중복하는가
    boolean existsByEntrepreNickName(String entrepreNickName);

    Optional<EntreEntity> findById(String id);

    EntreEntity getById(String id);

    EntreEntity findByEntrepreNum(int entrepreNum);


}
