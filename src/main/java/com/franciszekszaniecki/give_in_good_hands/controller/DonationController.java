package com.franciszekszaniecki.give_in_good_hands.controller;


import com.franciszekszaniecki.give_in_good_hands.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donation")
public class DonationController {
    private final CategoryRepository categoryRepository;

    public DonationController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/form")
    public String formAddDonation(Model model) {
        return "donationRegister/donationForm";
    }
}
