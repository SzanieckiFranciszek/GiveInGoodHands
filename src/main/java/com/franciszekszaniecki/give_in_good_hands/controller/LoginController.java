package com.franciszekszaniecki.give_in_good_hands.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {

    @GetMapping("/login")
    public String loginUser() {
        return "/loginUser/loginForm";
    }


}
