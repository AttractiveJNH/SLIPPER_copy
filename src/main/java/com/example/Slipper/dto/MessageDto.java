package com.example.Slipper.dto;

import com.example.Slipper.entity.userAndEntreEntities.Message;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class MessageDto {

    private Long id;

    private String title;

    private String content;

    private String sender;

    private String receiver;


}
