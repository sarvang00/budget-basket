package com.dal.PFE.service;

import com.dal.PFE.model.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryByName(String categoryName);
    List<Category> getAllCategory();
}
