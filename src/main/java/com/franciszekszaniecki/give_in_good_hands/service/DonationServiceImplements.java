package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.repository.DonationRepository;

public class DonationServiceImplements implements DonationService{
    private final DonationRepository donationRepository;

    public DonationServiceImplements(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }
}
