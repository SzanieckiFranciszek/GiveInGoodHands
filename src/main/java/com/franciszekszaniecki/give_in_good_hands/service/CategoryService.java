package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService  {
    List<Category> findAllCategory();
}
