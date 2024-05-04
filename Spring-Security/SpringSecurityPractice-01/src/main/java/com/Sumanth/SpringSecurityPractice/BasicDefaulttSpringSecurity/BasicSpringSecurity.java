package com.Sumanth.SpringSecurityPractice.BasicDefaulttSpringSecurity;

import org.springframework.boot.autoconfigure.jdbc.EmbeddedDataSourceConfiguration;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class BasicSpringSecurity {

    @Bean
    public  SecurityFilterChain basicSecurity(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request->
            request.requestMatchers("/contact","/notice").permitAll()
                    .requestMatchers("/balance","/card","/account").authenticated()
        );
        http.formLogin();
        http.httpBasic();
        return http.build();
    }
//    @Bean
//    public UserDetailsService createUsers(){
//        UserDetails user=User.withDefaultPasswordEncoder().username("sumanth").password("12345").authorities("user").build();
//        UserDetails admin=User.withDefaultPasswordEncoder().username("sai").password("123").authorities("admin").build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }
    @Bean
    public UserDetailsService createusers(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder createPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public SecurityFilterChain basicSecurity(HttpSecurity http){
//        try {
//            http.authorizeHttpRequests((requests) -> {
//                requests.anyRequest().authenticated();
//            });
//            http.sessionManagement(session->{
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            });
//            //http.formLogin(Customizer.withDefaults());
//            http.csrf().disable();
//            http.httpBasic(Customizer.withDefaults());
//            return (SecurityFilterChain)http.build();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//   public SecurityFilterChain newSecurityFilterchain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(request->{
//            request.anyRequest().authenticated();
//        });
//        http.sessionManagement(session->{
//            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        });
//        http.csrf().disable();
//        http.httpBasic();
//        return http.build();
//   }
//   @Bean
//   public UserDetailsService inMemoeryUserDetails(){
//        var user1=User.withUsername("sumanth").password("{noop}123").roles("ADMIN","USER").build();
//       var user2=User.withUsername("vyshu").password("{noop}123").roles("USER").build();
//
//       return new InMemoryUserDetailsManager(user1,user2);
//   }
//
}
