package com.example.Slipper.controller;

import com.example.Slipper.entity.userAndEntreEntities.UserEntity;
import com.example.Slipper.service.loginAndJoinServices.JoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPage")
@Slf4j
public class MyPageController {

    @Autowired
    JoinService joinService;
    @GetMapping("/main")
    public String myPageMain(Model model, UserEntity userInfo) throws
            Exception{
        model.addAttribute("userInfo", userInfo);
        return "myPage/myPageMain";
    }

    @GetMapping("/myArticleList")
    public String myArticleListP(){

        return "myPage/myArticleList";
    }
   
}
