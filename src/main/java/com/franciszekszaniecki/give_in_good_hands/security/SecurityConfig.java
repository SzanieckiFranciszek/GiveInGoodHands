package com.franciszekszaniecki.give_in_good_hands.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService springDataUserService() {
        return new SpringDataUserDetailsService();
    }
    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "This is the test email template for your email:%s");
        return message;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasAnyRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .loginPage("/login")
                .defaultSuccessUrl("/")
//                .usernameParameter("email")
//                .loginPage("/admin/login")
//                .defaultSuccessUrl("/userList")
                .and()
                .logout()
                .logoutSuccessUrl("/login")//Przekierowanie po wylogowaniu
                .permitAll();

    }
}
