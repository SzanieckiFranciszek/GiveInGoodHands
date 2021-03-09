package com.franciszekszaniecki.give_in_good_hands.repository;

import com.franciszekszaniecki.give_in_good_hands.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Override
    List<Category> findAll();
}
