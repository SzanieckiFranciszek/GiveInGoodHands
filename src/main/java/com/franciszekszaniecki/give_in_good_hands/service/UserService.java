package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getUsers();
    User findByUserEmail(String email);
    void saveUser(User user);
    void add(User user);
    void update(User user);
    void delete(Long id);
    User get(Long id);
}
