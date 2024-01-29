package com.example.Slipper.repository.userAndEntreRepositories;

import com.example.Slipper.entity.SswTestEntity.Entrepreneur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepreneurRepository extends JpaRepository<Entrepreneur, Integer> {

    Entrepreneur findById(int entrepreNum);
}
