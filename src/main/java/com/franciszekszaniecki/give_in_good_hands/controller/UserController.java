

package com.franciszekszaniecki.give_in_good_hands.controller;

import com.franciszekszaniecki.give_in_good_hands.model.User;
import com.franciszekszaniecki.give_in_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String saveRegistrationUser(Model model) {

        model.addAttribute("user", new User());
        return "user/registerForm";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String saveRegistrationUserPost(
            @ModelAttribute("user") User user, @RequestParam("password2") String password2, Model model) {
        if (!user.getPassword().equals(password2)) {
            model.addAttribute("wrongPassword", "Hasła nie są takie same, proszę podaj jeszcze raz");
            return "user/registerForm";
        }
        userService.add(user);
        userService.saveUser(user);

        return "user/emailSent";
    }


    @GetMapping("/user/confirm")
    public String confirmToken(@RequestParam String token) {
        userService.confirmToken(token);
        return "user/activationAccount";

    }


}

