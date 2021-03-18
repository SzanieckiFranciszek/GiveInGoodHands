package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Category;
import com.franciszekszaniecki.give_in_good_hands.repository.CategoryRepository;
import com.franciszekszaniecki.give_in_good_hands.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImplements implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImplements(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}