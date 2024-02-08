package com.example.Slipper.service;

import com.example.Slipper.dto.MessageDto;
import com.example.Slipper.entity.userAndEntreEntities.EntreEntity;
import com.example.Slipper.entity.userAndEntreEntities.Message;
import com.example.Slipper.entity.userAndEntreEntities.UserEntity;
import com.example.Slipper.repository.userAndEntreRepositories.EntreRepository;
import com.example.Slipper.repository.userAndEntreRepositories.MessageRepository;
import com.example.Slipper.repository.userAndEntreRepositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.codehaus.groovy.control.Janitor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;


import java.io.PrintWriter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    private final EntreRepository entreRepository;





//    @Transactional
//    public MessageDto write(MessageDto messageDto, @SessionAttribute(name = "id", required = false) String id) {
//
//
//        Optional<UserEntity> userReceiver = userRepository.findById(messageDto.getReceiver());
//        Optional<EntreEntity> entreReceiver = entreRepository.findById(messageDto.getReceiver());
//
//        Optional<UserEntity> userSender = userRepository.findById(messageDto.getSender());
//        Optional<EntreEntity> entreSender = entreRepository.findById(messageDto.getSender());
//
//        com.example.Slipper.entity.userAndEntreEntities.Message message = new Message();
//
//        if (id.equals(entreReceiver)) {
//
//            message.setReceiver();
//            message.setSender(sender);
//
//            message.setTitle(messageDto.getTitle());
//            message.setContent(messageDto.getContent());
//            message.setDeletedByReceiver(false);
//            message.setDeletedBySender(false);
//            messageRepository.save(message);
//
//            return MessageDto.toDto(message);
//        }
    }
