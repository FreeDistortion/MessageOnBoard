package kr.co.koreasign.messageonboard.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
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
                .authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/vks/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // PasswordEncoder 빈 정의
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
