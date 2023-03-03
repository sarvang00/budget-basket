package com.dal.PFE.service;

import com.dal.PFE.dao.ProductDaoImpl;
import com.dal.PFE.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDaoImpl productDao;


    public List<Product> getAllProducts(String searchbar_entry){
        if(searchbar_entry.equals("")) {
            return productDao.findAll();
        }
        else {
            return productDao.findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(searchbar_entry, searchbar_entry);
        }
    }


}

