package com.dal.PFE.controller;

import com.dal.PFE.model.*;
import com.dal.PFE.service.MartService;
import com.dal.PFE.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    MartService martService;

    @GetMapping("/getAllProductsIdsSearched")
    public List<Product> getAllProductsIdsSearched(@RequestParam(value="keyword",defaultValue = "") String searchbar_entry) {

        return productService.getAllProductsIdsSearched(searchbar_entry);
    }

    @GetMapping("/getAllSearchedProducts")
    public List<ProductAndMart> getAllSearchedProducts(@RequestParam(value="keyword",defaultValue = "") String searchbar_entry){

        return productService.getAllSearchedProducts(searchbar_entry);
    }

    @GetMapping("/getAllProductsFromKroger")
    public List<Kroger> getAllProductsFromKroger(){
        return martService.getAllProductFromKroger();
    }

    @GetMapping("/getAllProductsFromAide")
    public List<Aide> getAllProductsFromAide(){
        return martService.getAllProductFromAide();
    }

    @GetMapping("/getAllProductsFromTraderJoe")
    public List<TraderJoe> getAllProductsFromTraderJoe(){ return martService.getAllProductFromTraderJoe();}





}
