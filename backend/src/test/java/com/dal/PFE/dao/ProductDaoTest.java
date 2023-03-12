package com.dal.PFE.dao;

import com.dal.PFE.FinancialEconomizerBackendApplication;
import com.dal.PFE.dao.ProductDao;
import com.dal.PFE.dao.ProductDaoImpl;
import com.dal.PFE.model.Category;
import com.dal.PFE.model.Product;
import com.dal.PFE.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = FinancialEconomizerBackendApplication.class)

public class ProductDaoTest {

    private ProductDao productDao;
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        productRepository = mock(ProductRepository.class);
        productDao = new ProductDaoImpl(productRepository);
    }

    @Test
    public void testFindByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase() {
        Category category = new Category();
        category.setCategoryName("fruits");

        Product product1 = new Product(1L, "apple");
        product1.setCategory(category);

        Product product2 = new Product(2L, "orange");
        product2.setCategory(category);

        List<Product> expectedProducts = Arrays.asList(product1, product2);

        when(productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase("fru", "")).thenReturn(expectedProducts);

        List<Product> actualProducts = productDao.findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase("fru", "");

        assertEquals(expectedProducts.size(), actualProducts.size());
        assertEquals(expectedProducts.get(0).getName(), actualProducts.get(0).getName());
        assertEquals(expectedProducts.get(0).getCategory(), actualProducts.get(0).getCategory());
        assertEquals(expectedProducts.get(1).getName(), actualProducts.get(1).getName());
        assertEquals(expectedProducts.get(1).getCategory(), actualProducts.get(1).getCategory());
    }
}
