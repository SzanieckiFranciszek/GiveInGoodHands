package com.franciszekszaniecki.give_in_good_hands.service;


import org.springframework.stereotype.Service;

@Service
public interface DonationService {
    Long allBags();
    Long allTransferedDonation();
}
