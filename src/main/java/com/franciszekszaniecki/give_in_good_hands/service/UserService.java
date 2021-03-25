package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    User findByUserEmail(String email);

    User findByUserId(Long id);

    void saveUser(User user);

    void add(User user);

    void update(User user);

    void delete(Long id);

    User get(Long id);

    int enableUser(String email);

    String confirmToken(String token);

    Long numberOfConfirmedUser();

    Long numberOfAllUsers();

    List<User> findUserWhoIsAdmin();

    Long numberOfAllAdmins();

    void changeEnableStatus(Long id);
}
