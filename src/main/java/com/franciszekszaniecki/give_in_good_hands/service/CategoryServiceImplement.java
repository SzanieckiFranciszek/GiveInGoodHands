package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Category;
import com.franciszekszaniecki.give_in_good_hands.repository.CategoryRepository;

public class CategoryServiceImplement implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImplement(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
