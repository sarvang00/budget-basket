package com.dal.PFE.service;

import com.dal.PFE.model.Product;
import com.dal.PFE.model.ProductAndMart;

import java.util.List;

public interface ProductService {

    List<Product> getAllProductsIdsSearched(String searchbar_entry);

    List<ProductAndMart> getAllSearchedProducts(String keyword);

}
