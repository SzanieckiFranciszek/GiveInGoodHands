package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Category;
import com.franciszekszaniecki.give_in_good_hands.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImplement implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImplement(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}