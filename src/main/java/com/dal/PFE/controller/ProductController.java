package com.dal.PFE.controller;

import com.dal.PFE.model.Aide;
import com.dal.PFE.model.Kroger;
import com.dal.PFE.model.Product;
import com.dal.PFE.model.TraderJoe;
import com.dal.PFE.service.MartService;
import com.dal.PFE.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    MartService martService;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(@RequestParam(defaultValue = "") String searchbar_entry) {
        return productService.getAllProducts(searchbar_entry);

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
