package com.dal.economizer.service;

import com.dal.economizer.dao.ProductDao;
import com.dal.economizer.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts(){
        return (List<Product>) productDao.findAll();
    }

}

