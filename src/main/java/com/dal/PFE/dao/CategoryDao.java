package com.dal.PFE.dao;

import com.dal.PFE.model.Category;
import com.dal.PFE.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDao {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryDao(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findByCategoryNameIgnoreCase(String categoryName) {
        return categoryRepository.findByCategoryNameIgnoreCase(categoryName);
    }

    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

}

