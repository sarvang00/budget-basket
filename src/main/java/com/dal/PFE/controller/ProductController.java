package com.dal.PFE.controller;

import com.dal.PFE.model.Product;
import com.dal.PFE.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;
    @GetMapping({"/getAllProducts"})
    public List<Product> getAllProducts(@RequestParam(defaultValue = "") String searchbar_entry) {
        return productService.getAllProducts(searchbar_entry);

    }
}
