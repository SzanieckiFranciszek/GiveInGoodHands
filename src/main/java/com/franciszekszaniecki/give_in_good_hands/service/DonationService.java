package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Donation;

import java.util.List;


public interface DonationService {
    Long allBags();

    Long allTransferDonation();

    void add(Donation donation);

    List<Donation> allDonations();

    Donation findById(Long id);

    Donation update(Donation donation);
}
