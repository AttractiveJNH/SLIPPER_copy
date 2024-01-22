package com.example.Slipper.config;

import org.hibernate.cache.spi.support.CacheUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    // 비밀번호 암호화 Bean
    @Bean
    BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //권한에 따라 오픈되는 페이지 등록
        /* authorizeHttpRequest 접근 권한 설정*/
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/main", "/login", "/css/**",
                                "/join", "/joinProc",
                                "/myPage/**").permitAll()
                        .requestMatchers("/user_loginProc").hasRole("USER")
                        .requestMatchers("/entre_loginProc").hasRole("ENTRE")
                        //.requestMatchers("/myPage/**").hasAnyRole("ADMIN", "ENTREPRE", "USER")
                        .anyRequest().authenticated())


                //로그인
                // SecurityConfig.java
                .formLogin((formLogin) -> {
                    formLogin.loginPage("/login");

                    // "/login" 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행.
                    // 결과적으로 컨트롤러에 따로 "/login"을 구현하지 않아도 괜찮다.
                    // 이 로그인 과정에서 필요한 것이 있기 때문에 auth 패키지를 파서 PrincipalDetails 을 만들어줘야한다.
                    formLogin.loginProcessingUrl("/login");

                    // 로그인이 끝나면 리다이렉트할 url
                    formLogin.defaultSuccessUrl("/");
                })

                .build();

        /* 모든 Request 허락 */
//        http.authorizeHttpRequests((auth) -> auth.anyRequest().permitAll())
//                        .formLogin(Customizer.withDefaults())
//                                .httpBasic(Customizer.withDefaults());
//        return http.build();

        /* 모든 Request 거절 */
//        http.authorizeHttpRequests((auth) -> auth.anyRequest().denyAll())
//                        .formLogin(Customizer.withDefaults())
//                                .httpBasic(Customizer.withDefaults());
//        return http.build();


        http
                .csrf((auth) -> auth.disable());

//         개발중이니까 disable

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
