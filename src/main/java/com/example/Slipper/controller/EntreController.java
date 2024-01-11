package com.example.Slipper.controller;


import com.example.Slipper.dto.EntreDto;
import com.example.Slipper.service.JoinService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


// 유저 컨트롤러
@Controller
@Slf4j
public class EntreController {

    @Autowired
    private JoinService joinService;

    // 로그인 페이지 맵핑

    @GetMapping("/login")
    public String loginP(){
        return "login";
    }

    // 로그인 성공 시 맵핑
    @PostMapping("/login")
    public String login(){

        return "main";
    }


    // 사업자 회원 가입 맵핑
    @GetMapping("/entre_join")
    public String entreJoinP(){
        return "signup/entre_signup";
    }

    //회원가입 성공 시 맵핑
    @PostMapping("/entre_joinProc")
    public String entreJoinProc(EntreDto entreDto){



         log.info(entreDto.getEntrepreId());

        joinService.entreJoinProcess(entreDto);
        return "redirect:/login";
    }

}
