package com.dal.PFE.dao;

import com.dal.PFE.model.Product;
import com.dal.PFE.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao{
    @Autowired
    ProductRepository productRepository;


    public List<Product> findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(String entry1, String entry2) {
        return productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(entry1, entry2);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}


