package com.franciszekszaniecki.give_in_good_hands.service;


import com.franciszekszaniecki.give_in_good_hands.model.Token;
import com.franciszekszaniecki.give_in_good_hands.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(Token token) {

        confirmationTokenRepository.save(token);
    }

    public Optional<Token> getToken(String token) {

        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

}
