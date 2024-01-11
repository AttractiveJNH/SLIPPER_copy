package com.example.Slipper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


//사업자 컨트롤러
public class EntreController {


    @GetMapping("/entre_join")
    public String entreJoinP(){
        return "signup/entre_signup";
    }

    @PostMapping("/entre_joinProc")
    public String entreJoinProc(){
        return "redirect:/login";
    }
}
