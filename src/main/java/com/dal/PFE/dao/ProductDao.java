package com.dal.PFE.dao;

import com.dal.PFE.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(String entry1, String entry2);



}
