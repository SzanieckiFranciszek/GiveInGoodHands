package com.franciszekszaniecki.give_in_good_hands.controller;


import com.franciszekszaniecki.give_in_good_hands.model.User;
import com.franciszekszaniecki.give_in_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        return "registrationUser/registerForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAddUser(@Valid @ModelAttribute("user") User user,@RequestParam("password2") String password2, BindingResult result) {
        if (!user.getPassword().equals(password2)) {

            return "registrationUser/registerForm";
        }
        userService.add(user);
        userService.saveUser(user);
        return "redirect:/";
    }


}
