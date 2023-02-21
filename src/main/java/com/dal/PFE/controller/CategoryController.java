package com.dal.PFE.controller;

import com.dal.PFE.model.Category;
import com.dal.PFE.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/getCategoryByName"})
    public Category getCategoryByName(@RequestParam String categoryName) {
        return categoryService.getCategoryByName(categoryName);
    }
}
