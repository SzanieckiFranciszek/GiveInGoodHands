package com.franciszekszaniecki.give_in_good_hands.repository;

import com.franciszekszaniecki.give_in_good_hands.model.Donation;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("select sum(d.quantity) from Donation d")
    Long allBags();
}
