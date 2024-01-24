package com.example.Slipper.controller;

import com.example.Slipper.dto.LoginRequest;
import com.example.Slipper.entity.UserEntity;
import com.example.Slipper.repository.UserRepository;
import com.example.Slipper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor

public class MainController {

    private  final UserService userService;

    private final UserRepository userRepository;


    @GetMapping("/main")
    public String mainPage(Model model, Authentication auth){

        if (auth != null){
            UserEntity loginUser = userService.getLoginUserByLoginId(auth.getName());
            if (loginUser != null){
                model.addAttribute("nickName", loginUser.getUserNickName());
            }
        }
        return "main";
    }


    @GetMapping("/login")
    public String loginP(Model model){

        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    // 로그인 성공 시 맵핑
    @PostMapping("/login_proc")
    public String login(){



        return "redirect:/main";
    }

    /**
     *  로그인 기능
     *  화면에서 LoginRequest(loginId, password)을 입력받아 loginId와 password가 일치하면 User return
     *  loginId가 존재하지 않거나 password가 일치하지 않으면 null return
     */
    public UserEntity login(LoginRequest req) {
        Optional<UserEntity> optionalUser = userRepository.findByUserId(req.getLoginId());

        // loginId와 일치하는 User가 없으면 null return
        if(optionalUser.isEmpty()) {
            return null;
        }

        UserEntity user = optionalUser.get();

        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if(!user.getUserPassword().equals(req.getPassword())) {
            return null;
        }

        return user;
    }

    /**
     * userId(Long)를 입력받아 User을 return 해주는 기능
     * 인증, 인가 시 사용
     * userId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
     * userId로 찾아온 User가 존재하면 User return
     */
    public UserEntity getLoginUserById(Long userId) {
        if(userId == null) return null;

        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }

    /**
     * loginId(String)를 입력받아 User을 return 해주는 기능
     * 인증, 인가 시 사용
     * loginId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
     * loginId로 찾아온 User가 존재하면 User return
     */
    public UserEntity getLoginUserByLoginId(String loginId) {
        if(loginId == null) return null;

        Optional<UserEntity> optionalUser = userRepository.findByUserId(loginId);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }

}
