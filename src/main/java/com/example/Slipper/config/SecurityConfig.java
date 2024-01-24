package com.example.Slipper.config;

import com.example.Slipper.service.UserDetailService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    public final UserDetailService userService;

    public SecurityConfig(UserDetailService userService) {
        this.userService = userService;
    }

    // 비밀번호 암호화 Bean
    @Bean
    BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }


    /* 이 메서드는 정적 자원(static)에 대해 보한을 적용하지 않도록 설정한다.
     * 정적 자원 = 보통 HTML, CSS, JavaScript, img 파일 등을 의미하며, 이들에 대해 보안을
     * 적용하지 않음으로써 성능을 향상시킬 수 있다. */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //권한에 따라 오픈되는 페이지 등록
        /* authorizeHttpRequest 접근 권한 설정*/
        http
                .authorizeHttpRequests((auth) -> auth

                        .requestMatchers("/", "/main", "/login",
                                "/join", "/user_join","/entre_join",
                                "/myPage/**").permitAll()
//                        .requestMatchers().hasRole("ADMIN")
                        .anyRequest().authenticated());


        //로그인 설정
        http.
                formLogin((auth) -> auth.loginPage("/login") // 로그인 페이지
                        .defaultSuccessUrl("/") //로그인 성공 후 페이지
                        .failureUrl("/login") // 로그인 실패 후 페이지
                        .usernameParameter("loginId") // 아이디 파라미터명 설정
                        .passwordParameter("password") // 비밀번호 파라미터명 설정
                        .loginProcessingUrl("/login_proc") // 로그인 form Action Url.
                        //로그인 성공 후 핸들러
                        .successHandler(
                                new AuthenticationSuccessHandler() {
                                    @Override
                                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                        System.out.println("authentication: " + authentication.getName());
                                        response.sendRedirect("/main");
                                    }
                                })
                        // 로그인 실패 후 핸들러
                        .failureHandler( // 로그인 실패 후 핸들러
                                new AuthenticationFailureHandler() { // 익명 객체 사용
                                    @Override
                                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                                        System.out.println("exception: " + exception.getMessage());
                                        response.sendRedirect("/login");
                                    }
                                })
                        .permitAll());


        return http.build();
    }


    // 로그아웃 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .logout((auth) -> auth.logoutUrl("/logout")
                        .logoutSuccessUrl("/"));
        return http.build();
    }


}
