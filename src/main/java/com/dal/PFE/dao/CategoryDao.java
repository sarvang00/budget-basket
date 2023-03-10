package com.dal.PFE.dao;

import com.dal.PFE.model.Category;

import java.util.List;

public interface CategoryDao {


    Category findByCategoryNameIgnoreCase(String categoryName);
}
