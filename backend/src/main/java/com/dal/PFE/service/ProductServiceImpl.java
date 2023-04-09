package com.dal.PFE.service;

import com.dal.PFE.dao.ProductDaoImpl;
import com.dal.PFE.model.Product;
import com.dal.PFE.model.ProductAndMart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDaoImpl productDao;

    @Override
    @Transactional
    public List<Product> getAllProductsIdsSearched(String searchbar_entry){
        if(searchbar_entry.equals("")) {
            return productDao.findAll();
        }
        else {
            return productDao.findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(searchbar_entry, searchbar_entry);
        }
    }

    @Override
    @Transactional
    public List<ProductAndMart> getAllSearchedProducts(String keyword) {
        return productDao.getAllSearchedProducts(keyword);
    }


}

