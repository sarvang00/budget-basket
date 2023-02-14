package com.dal.economizer.service;

import com.dal.economizer.dao.ProductDao;
import com.dal.economizer.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Scheduled(cron = "0 0 0/2 * * *")
    public void sendExpiryNotifications() {
        List<Product> products = productDao.findAll();
        for (Product product : products) {
            long timeDifference = product.getExpiryDate().getTime() - System.currentTimeMillis();
            if (timeDifference <= 2 * 24 * 60 * 60 * 1000) {
                System.out.println(product.getName() + " is going to expire, you may wanna consume it and restock it!");
            }
        }
    }
}

