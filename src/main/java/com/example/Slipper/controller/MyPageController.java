package com.example.Slipper.controller;

import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.UserRepository;
import com.example.Slipper.service.JoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.security.Principal;

@Controller
@RequestMapping("/myPage")
@Slf4j
public class MyPageController {

    @Autowired
    JoinService joinService;
    @GetMapping("/main")
    public String myPageMain(Model model, @AuthenticationPrincipal UserEntity userInfo) throws
            Exception{
        model.addAttribute("userInfo", userInfo);
        return "myPage/myPageMain";
    }

    @GetMapping("/myArticleList")
    public String myArticleListP(){

        return "myPage/myArticleList";
    }
   
}
