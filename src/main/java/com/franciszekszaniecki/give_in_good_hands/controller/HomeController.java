package com.franciszekszaniecki.give_in_good_hands.controller;

import com.franciszekszaniecki.give_in_good_hands.model.Institution;
import com.franciszekszaniecki.give_in_good_hands.service.DonationService;
import com.franciszekszaniecki.give_in_good_hands.service.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }
    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> allInstitution = institutionService.findAllInstitution();
        model.addAttribute("institutions", allInstitution);
        Long allBags=donationService.allBags();
        model.addAttribute("allBags",allBags);
        Long allTransferDonation = donationService.allTransferDonation();
        model.addAttribute("allTransferDonation",allTransferDonation);
        return "home";
    }
}
