package com.dal.PFE.service;

import com.dal.PFE.dao.CategoryDaoImpl;
import com.dal.PFE.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryDaoImpl categoryDao;

    public Category getCategoryByName(String categoryName) {
        return categoryDao.findByCategoryNameIgnoreCase(categoryName);
    }
}
