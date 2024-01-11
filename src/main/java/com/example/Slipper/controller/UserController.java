package com.example.Slipper.controller;

import com.example.Slipper.dto.UserDto;
import com.example.Slipper.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.spring6.context.SpringContextUtils;



// 유저 컨트롤러
@Controller
@Slf4j
public class UserController {

    @Autowired
    private JoinService joinService;

    // 로그인 맵핑

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // 유저 회원 가입
    @GetMapping("/user_join")
    public String userJoinP(){
        return "signup/user_signup";
    }
    @PostMapping("/user_joinProc")
    public String userJoinProc(UserDto userDto){



         log.info(userDto.getUserId());

        joinService.userJoinProcess(userDto);
        return "redirect:/login";
    }

}
