package com.example.Slipper.entity.promotionEntity;


import com.example.Slipper.entity.userAndEntreEntities.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Table(name = "promotion_board_comment")
@NoArgsConstructor

@Getter
@Setter
public class PromotionBoardComment {

    @Id
    @Column(name = "promo_brd_comnt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promoBrdComntId; // 번호

    @Column(name = "promo_brd_post_id")
    private int promoBrdPostId; // 홍보 게시판 번호

    @Column(name = "user_num")
    private Long userNum; // 유저 등록 번호

    @Column(name = "promo_brd_comnt_content")
    private String promoBrdComntContent; // 내용

    @Column(name = "promo_brd_comnt_date")
    private LocalDateTime  promoBrdComntDate; // 작성일
    private String userNickName; // 유저닉네임

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_num", insertable = false, updatable = false)
    private UserEntity user;



    public PromotionBoardComment(int promoBrdPostId, Long userNum, String promoBrdComntContent, LocalDateTime promoBrdComntDate, String userNickName) {
        this.promoBrdPostId = promoBrdPostId;
        this.userNum = userNum;
        this.promoBrdComntContent = promoBrdComntContent;
        this.promoBrdComntDate = promoBrdComntDate;
        this.userNickName = userNickName;
    }
}
