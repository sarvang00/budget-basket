package com.dal.PFE.controller;

import com.dal.PFE.model.Category;
import com.dal.PFE.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping({"/getCategoryByName"})
    public Category getCategoryByName(@RequestParam String categoryName) {
        return categoryService.getCategoryByName(categoryName);
    }
}
