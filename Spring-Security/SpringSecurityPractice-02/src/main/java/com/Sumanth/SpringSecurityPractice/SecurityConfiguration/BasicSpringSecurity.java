package com.Sumanth.SpringSecurityPractice.SecurityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicSpringSecurity {

    @Bean
    public  SecurityFilterChain basicSecurity(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request->
            request.requestMatchers("/contact","/notice","/register").permitAll()
                    .requestMatchers("/balance","/card","/account").authenticated()
        );
        http.csrf().disable();
        http.formLogin();
        http.httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder createPasswordEncode(){
        return new BCryptPasswordEncoder();
    }

}
