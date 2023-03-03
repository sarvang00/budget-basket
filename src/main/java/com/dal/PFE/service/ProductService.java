package com.dal.PFE.service;

import com.dal.PFE.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(String searchbar_entry);

}
