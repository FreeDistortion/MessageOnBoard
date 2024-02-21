package kr.co.koreasign.messageonboard.configs.security;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private static final String LOGINURL="/login";
    private static final String PUBLICPATH="/public/**";



    // SecurityFilterChain 빈 정의
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                // static resource에는 허용해야지
//                .requestMatchers("/css/**", "/js/**", "/signup", "/vks/message").permitAll()
//                .anyRequest().authenticated()
//
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                // 로그인 성공
//                .loginProcessingUrl("/")
//                // 로그인 실패
////                                .failureUrl("/login?error=true")
//                .failureUrl("/vks/message")
//                .permitAll() // 모든 사용자가 로그인 페이지 접근 가능
//                .successHandler()
//                .failureHandler();
//        http
//                .sessionManagement()
//                .invalidSessionUrl("/login")
//                .and()
//                .logout()
//                                .logoutSuccessUrl("/login?logout=true") // 로그아웃 성공 시 이동할 페이지
//                                .permitAll()
//                ;
//
//        return http.build();
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(PUBLICPATH)
                )
                .authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers(LOGINURL,"/css/**","/js/**",PUBLICPATH).permitAll()
                        .requestMatchers("/vks/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(
//                        login -> login
//                        .loginPage(LOGINURL)    // 로그인 시도 URL
//                        .usernameParameter("username")  // 로그인 시 사용될 사용자 이름 param name
//                        .passwordParameter("password")  // 로그인 시 사용될 비밀번호 param name
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/login")
//                        .permitAll()
                        Customizer.withDefaults()   // LoginPage구현하기 귀찮으니 기본값으로
                )
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")  // 로그아웃 처리 URL 설정
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)  // 로그아웃 시 세션 무효화
                        .deleteCookies("JSESSIONID")  // 로그아웃 시 쿠키 삭제
                        .permitAll()  // 모든 사용자가 로그아웃을 수행할 수 있도록 허용
                );
        return http.build();
    }

    // PasswordEncoder 빈 정의
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
