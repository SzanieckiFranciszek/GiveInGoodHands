package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Donation;
import com.franciszekszaniecki.give_in_good_hands.repository.DonationRepository;
import org.springframework.stereotype.Service;

@Service
public class DonationServiceImplements implements DonationService {
    private final DonationRepository donationRepository;

    public DonationServiceImplements(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Long allBags() {
        return donationRepository.allBags();
    }

    @Override
    public Long allTransferDonation() {
        return donationRepository.count();
    }

    @Override
    public void add(Donation donation) {
        donationRepository.save(donation);
    }
}
