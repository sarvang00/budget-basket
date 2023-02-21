package com.dal.PFE.service;

import com.dal.PFE.dao.CategoryDao;
import com.dal.PFE.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public Category getCategoryByName(String categoryName) {
        return categoryDao.findByCategoryNameIgnoreCase(categoryName);
    }
}
