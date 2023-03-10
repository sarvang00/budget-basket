package com.dal.PFE.service;

import com.dal.PFE.dao.CategoryDaoImpl;
import com.dal.PFE.model.Category;
import com.dal.PFE.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryDaoImpl categoryDao;

    public Category getCategoryByName(String categoryName) {
        return categoryDao.findByCategoryNameIgnoreCase(categoryName);
    }

    public List<Category> getAllCategory(){
        return categoryDao.findAll();
    }
}
