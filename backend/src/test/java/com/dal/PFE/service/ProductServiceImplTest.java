package com.dal.PFE.service;

import com.dal.PFE.dao.ProductDaoImpl;
import com.dal.PFE.model.Product;
import com.dal.PFE.model.ProductAndMart;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceImplTest {

    @Mock
    private ProductDaoImpl productDao;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testGetAllProductsIdsSearched() {
        String searchbarEntry = "";
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product());
        expectedProducts.add(new Product());

        // Mocking the behavior of productDao.findAll() method
        when(productDao.findAll()).thenReturn(expectedProducts);

        // Calling the method to be tested
        List<Product> actualProducts = productService.getAllProductsIdsSearched(searchbarEntry);

        // Assert
        assertEquals(expectedProducts.size(), actualProducts.size());
        verify(productDao).findAll();

        // Testing with searchbar_entry not empty
        searchbarEntry = "test";
        when(productDao.findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(searchbarEntry, searchbarEntry)).thenReturn(expectedProducts);
        actualProducts = productService.getAllProductsIdsSearched(searchbarEntry);
        assertEquals(expectedProducts.size(), actualProducts.size());
        verify(productDao).findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(searchbarEntry, searchbarEntry);
    }




    @Test
        public void testGetAllSearchedProducts() {

            String keyword = "test";
            List<ProductAndMart> expectedProducts = Arrays.asList(new ProductAndMart(), new ProductAndMart());

            // Mocking the behavior of productDao.getAllSearchedProducts() method
            when(productDao.getAllSearchedProducts(keyword)).thenReturn(expectedProducts);

            // Calling the method to be tested
            List<ProductAndMart> actualProducts = productService.getAllSearchedProducts(keyword);

            // Assert
            assertEquals(expectedProducts, actualProducts);
            verify(productDao).getAllSearchedProducts(keyword);
        }
    }

