package com.franciszekszaniecki.give_in_good_hands.service;


import com.franciszekszaniecki.give_in_good_hands.model.Donation;
import org.springframework.stereotype.Service;

public interface DonationService {
    Long allBags();
    Long allTransferedDonation();
    void add(Donation donation);
}
