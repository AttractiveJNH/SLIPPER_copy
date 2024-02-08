package com.example.Slipper.dto;

import com.example.Slipper.entity.userAndEntreEntities.Message;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class MessageDto {

    private String title;

    private String content;

    private String sender;

    private String receiver;

    public static MessageDto toDto(Message message){

        return new MessageDto(
                message.getTitle(),
                message.getContent(),
                message.getSender(),
                message.getReceiver()
        );
    }
}
