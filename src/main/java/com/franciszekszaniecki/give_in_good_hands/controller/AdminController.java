package com.franciszekszaniecki.give_in_good_hands.controller;

import com.franciszekszaniecki.give_in_good_hands.model.Donation;
import com.franciszekszaniecki.give_in_good_hands.model.User;
import com.franciszekszaniecki.give_in_good_hands.service.DonationService;
import com.franciszekszaniecki.give_in_good_hands.service.InstitutionService;
import com.franciszekszaniecki.give_in_good_hands.service.RoleService;
import com.franciszekszaniecki.give_in_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final RoleService roleService;

    public AdminController(UserService userService, DonationService donationService, InstitutionService institutionService, RoleService roleService) {
        this.userService = userService;
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.roleService = roleService;
    }

    @RequestMapping("/home")
    public String adminHomeScreen() {

        return "admin/adminHome";
    }


    //User

    @GetMapping(value = "/user/list")
    public String allUserAccountGet(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        model.addAttribute("numberAllUsers", userService.numberOfAllUsers());
        model.addAttribute("numberConfirmedUsers", userService.numberOfConfirmedUser());
        model.addAttribute("numberNotConfirmedUsers", (userService.numberOfAllUsers() - userService.numberOfConfirmedUser()));
        return "user/list";
    }

    @GetMapping("/user/enable/{id}")
    public String userEnableOrUnEnable(@PathVariable Long id) {
        userService.changeEnableStatus(id);
        return "redirect:/admin/user/list";
    }

    @GetMapping("/user/edit/{id}")
    public String editUserMethodGet(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findByUserId(id));
        model.addAttribute("roles", roleService.findAllRole());

        return "user/edit";
    }

    @PostMapping("/user/edit/{id}")
    public String editUserMethodPost(User user) {
        User userById = userService.findByUserId(user.getId());
        user.setPassword(userById.getPassword());
        user.setEnabled(userById.isEnabled());
        if (user.getRoles() == null) {
            user.setRoles(userById.getRoles());
        }
        userService.update(user);

        return "redirect:/admin/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        User userFindById = userService.findByUserId(id);
        userService.delete(id);
        return "redirect:/admin/user/list";
    }

//    @GetMapping("/admin/user/edit/{}")
//    public String editUserGet(){
//
//    }

    //Admin

    @GetMapping("/list")
    public String adminsList(Model model) {
        model.addAttribute("admins", userService.findUserWhoIsAdmin());
        model.addAttribute("numberOfAdmins", userService.numberOfAllAdmins());
        return "admin/adminList";
    }

    //Donation

    @GetMapping("/donation/list")
    public String donationsList(Model model) {
        model.addAttribute("donations", donationService.allDonations());
        model.addAttribute("numberOfDonations", donationService.allBags());

        return "/donation/list";
    }

    @GetMapping("/donation/edit/{id}")
    public String editDonationGet(@PathVariable Long id, Model model) {
        model.addAttribute("donation", donationService.findById(id));

        return "donation/edit";
    }

    @PostMapping("/donation/edit/{id}")
    public String editDonationPost(Donation donation) {
        donationService.update(donation);

        return "redirect:/admin/donation/list";
    }


    //Institutions

    @GetMapping("/institutions/list")
    public String institutionsList(Model model) {
        model.addAttribute("institutions", institutionService.findAllInstitution());
        model.addAttribute("numberAllInstitutions", institutionService.numberOfAllInstitutions());
        return "/institutions/list";
    }
}
