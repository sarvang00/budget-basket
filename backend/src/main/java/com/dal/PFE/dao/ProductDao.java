package com.dal.PFE.dao;

import com.dal.PFE.model.Product;
import com.dal.PFE.model.ProductAndMart;

import java.util.List;

public interface ProductDao {

    List<Product> findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(String entry1, String entry2);


    List<ProductAndMart> getAllSearchedProducts(String keyword);


}
