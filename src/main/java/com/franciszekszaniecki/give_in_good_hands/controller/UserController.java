package com.franciszekszaniecki.give_in_good_hands.controller;


import com.franciszekszaniecki.give_in_good_hands.model.User;
import com.franciszekszaniecki.give_in_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String saveRegistrationUser(Model model) {

        model.addAttribute("user", new User());
        return "user/registerForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveRegistrationUserPost(
            @ModelAttribute("user") User user, @RequestParam("password2") String password2) {
        if (!user.getPassword().equals(password2)) {
            return "user/registerForm";
        }
        userService.add(user);
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/confirm")
    public String confirmToken(@RequestParam String token) {
        return userService.confirmToken(token);

    }


}
