package com.example.Slipper.entity.userAndEntreEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name= "message")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 메세지 테이블의 pk


    @Column(nullable = false)
    private String title; //메세지 제목

    @Column(nullable = false)
    private String content;//메세지 내용




    @Column(nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private String  sender;


    @Column(nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private String receiver;


    @Column(nullable = false)
    private boolean deletedBySender;

    @Column(nullable = false)
    private boolean deletedByReceiver;

    @JoinColumn(name = "user_num")
    @ManyToOne
    private UserEntity user;

    @JoinColumn(name = "entrepreneur_num")
    @ManyToOne
    private EntreEntity entre;


    public void deleteBySender() {
        this.deletedBySender = true;
    }

    public void deleteByReceiver() {
        this.deletedByReceiver = true;
    }

    public boolean isDeleted() {
        return isDeletedBySender() && isDeletedByReceiver();
    }
}

