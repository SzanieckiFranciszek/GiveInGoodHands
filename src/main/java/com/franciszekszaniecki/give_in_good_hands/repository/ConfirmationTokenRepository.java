package com.franciszekszaniecki.give_in_good_hands.repository;

import com.franciszekszaniecki.give_in_good_hands.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<Token,Long> {

    Optional<Token> findByToken(String token);

    @Transactional
    @Modifying
    @Query("update Token a set a.confirmedAt = ?2 where a.token = ?1")
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}
