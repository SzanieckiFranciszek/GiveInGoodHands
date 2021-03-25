package com.franciszekszaniecki.give_in_good_hands.repository;

import com.franciszekszaniecki.give_in_good_hands.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User a SET a.enabled = TRUE where a.email =?1")
    int enableUser(String email);

    @Query("select count(d.enabled) from User d where d.enabled = true")
    Long numberOfConfirmedUser();

    @Query("select count(a.id) from User a")
    Long numberOfAllUsers();

    @Query(value = "select  *  from user d join user_roles ur on d.id = ur.user_id where roles_id=1", nativeQuery = true)
    List<User> findUserWhoIsAdmin();

    @Query(value = "select  count(d.id)  from user d join user_roles ur on d.id = ur.user_id where roles_id=1;", nativeQuery = true)
    Long numberOfAllAdmins();

    @Query(value = "select enabled from user d where d.id =?1", nativeQuery = true)
    Boolean enableStatus(Long id);
    @Transactional
    @Modifying

    @Query("update User a SET a.enabled = TRUE where a.id =?1")
    void changeStatusEnableToTrue(Long id);
    @Transactional
    @Modifying
    @Query("update User a SET a.enabled = FALSE where a.id =?1")
    void changeStatusEnableToFalse(Long id);

}


