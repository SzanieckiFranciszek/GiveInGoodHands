package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.repository.InstitutionRepository;

public class InstitutionServiceImplements implements InstitutionService{
    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImplements(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
}

