package com.franciszekszaniecki.give_in_good_hands.repository;

import com.franciszekszaniecki.give_in_good_hands.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {
    @Query(value = "select sum(d.id) from Institution d")
    Long numberOfAllInstitutions();
}
