package com.example.mysecurity.config;

import com.example.mysecurity.model.enums.RoleEnum;
import com.example.mysecurity.repository.UserRepository;
import com.example.mysecurity.service.ApplicationUserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                authorizeHttpRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/","/users/login","/users/register","/users/login-errors").permitAll()
                .requestMatchers("/pages/moderators").hasRole(RoleEnum.MODERATOR.name())
                .requestMatchers("/pages/admins").hasRole(RoleEnum.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin().usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                .loginPage("/users/login")
                .defaultSuccessUrl("/",true)
                .failureForwardUrl("/users/login-errors");

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository ){
        return new ApplicationUserDetailService(userRepository);
    }
}
