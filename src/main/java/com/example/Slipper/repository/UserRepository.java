package com.example.Slipper.repository;

import com.example.Slipper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId); // ID로 유저 정보를 가져옴
}
