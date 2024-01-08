package com.example.Slipper.controller;

import com.example.Slipper.dto.UserDto;
import com.example.Slipper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }
    //회원가입 완료 시 돌아가는 페이지
    @PostMapping("/user")
    public String signUp(UserDto userDto){
        userService.save(userDto); // 회원가입 메서드 호출
        return "redirect:/login"; // 회원가입 완료되면 로그인 페이지로 이동
    }


}
