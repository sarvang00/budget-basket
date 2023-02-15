package com.dal.economizer.controller;

import com.dal.economizer.model.Product;
import com.dal.economizer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping({"/getAllProducts"})
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }
}

