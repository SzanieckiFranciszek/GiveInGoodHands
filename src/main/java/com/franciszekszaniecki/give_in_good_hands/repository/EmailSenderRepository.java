package com.franciszekszaniecki.give_in_good_hands.repository;

public interface EmailSenderRepository {
    void send(String to, String email);
}
