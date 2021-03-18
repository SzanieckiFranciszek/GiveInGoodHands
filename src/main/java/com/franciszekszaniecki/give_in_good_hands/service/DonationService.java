package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Donation;


public interface DonationService {
    Long allBags();
    Long allTransferDonation();
    void add(Donation donation);
}
