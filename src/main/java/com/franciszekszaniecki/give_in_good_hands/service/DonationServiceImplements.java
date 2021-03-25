package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Donation;
import com.franciszekszaniecki.give_in_good_hands.model.User;
import com.franciszekszaniecki.give_in_good_hands.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Donation> allDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Donation findById(Long id) {
        return donationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Donation with id=%s doestn't exist", id)));
    }

    @Override
    public Donation update(Donation donation) {
        return donationRepository.save(donation);
    }

}
