package com.dal.PFE.dao;

import com.dal.PFE.model.Category;
import com.dal.PFE.model.Product;
import com.dal.PFE.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    CategoryRepository categoryRepository;


    public Category findByCategoryNameIgnoreCase(String categoryName) {
        return categoryRepository.findByCategoryNameIgnoreCase(categoryName);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}

