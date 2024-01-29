package com.example.Slipper.controller;

import com.example.Slipper.dto.LoginRequest;
import com.example.Slipper.entity.EntreEntity;
import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.EntreRepository;
import com.example.Slipper.repository.UserRepository;
import com.example.Slipper.service.EntreService;
import com.example.Slipper.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.BinaryOperator;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final UserService userService;

    private final UserRepository userRepository;

    private final EntreService entreService;

    private final EntreRepository entreRepository;


    @GetMapping("/main")
    public String mainPage() {

        return "main";
    }


    @GetMapping("/login")
    public String loginP(Model model) {

        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    // 로그인 성공 시 맵핑
    @PostMapping("/login_proc")
    public String loginRequest(@ModelAttribute LoginRequest loginRequest, BindingResult bindingResult,
                               HttpServletRequest httpServletRequest, Model model, @RequestParam(required = false) String id) {

        model.addAttribute("loginType", "slipper");

        UserEntity user = userService.login(loginRequest);
        EntreEntity entre = entreService.login(loginRequest);

        UserEntity requestUser = userRepository.getById(id) ;
        EntreEntity requestEntre = entreRepository.getById(id);
        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if (user == null && entre == null) {
            bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다.");
        }


        if (bindingResult.hasErrors()) {
            return "login";
        }
        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌

        if (user != null && user == requestUser) {
            session.setAttribute("id", user.getId());
            session.setMaxInactiveInterval(1800); // Session이 30분동안 유지
        } else if (entre != null && entre == requestEntre) {
            session.setAttribute("id", entre.getId());
            session.setMaxInactiveInterval(1800); // Session이 30분동안 유지
        }

        return "redirect:/main";
    }


}
