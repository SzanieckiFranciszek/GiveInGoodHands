package com.franciszekszaniecki.give_in_good_hands.controller;


import com.franciszekszaniecki.give_in_good_hands.model.Donation;
import com.franciszekszaniecki.give_in_good_hands.service.CategoryService;
import com.franciszekszaniecki.give_in_good_hands.service.DonationService;
import com.franciszekszaniecki.give_in_good_hands.service.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @GetMapping("/form")
    public String formAddDonation(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("institutions", institutionService.findAllInstitution());
        return "donation/donationForm";
    }

    @PostMapping("/form")
    public String formAddDonationPost(Donation donation) {
        donationService.add(donation);
        return "donation/confirmForm";
    }



}
