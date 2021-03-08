package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Institution;
import com.franciszekszaniecki.give_in_good_hands.repository.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstitutionServiceImplements implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImplements(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAllInstitution() {
        return institutionRepository.findAll();
    }
}

