package com.example.Slipper.controller;

import com.example.Slipper.dto.UserDto;
import com.example.Slipper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
@Transactional
public class UserController {

    private final UserService userService;

    //메인 테스트
    @GetMapping("/main")
    public String main(){
        return "main";
    }

    //로그인 맵핑
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new UserDto());
        return "login";
    }

    //회원가입 페이지 맵핑
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("userDto", new UserDto());
        return "signup";
    }


    //회원가입 완료 시 돌아가는 페이지
    @PostMapping("/signup")
    public String signUp(UserDto userDto){


      userService.save(userDto); // 회원가입 메서드 호출

        System.out.println(userDto);
        return "redirect:/login"; // 회원가입 완료되면 로그인 페이지로 이동
    }


}
