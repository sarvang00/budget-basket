package com.dal.PFE.dao;

import com.dal.PFE.model.Category;
import com.dal.PFE.model.Product;
import com.dal.PFE.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductDaoImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductDaoImpl productDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Product1"));
        products.get(0).setCategory(new Category());
        products.get(0).getCategory().setCategoryName("Category1");
        products.add(new Product(2L, "Product2"));
        products.get(1).setCategory(new Category());
        products.get(1).getCategory().setCategoryName("Category2");

        when(productRepository.findAll()).thenReturn(products);

        // Act
        List<Product> actualProducts = productDao.findAll();

        // Assert
        assertEquals(products.size(), actualProducts.size());
    }

    @Test
    public void testFindByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase() {
        // Arrange
        String entry1 = "apple";
        String entry2 = "fruit";

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Apple"));
        products.get(0).setCategory(new Category());
        products.get(0).getCategory().setCategoryName("Fruit");
        products.add(new Product(2L, "Orange"));
        products.get(1).setCategory(new Category());
        products.get(1).getCategory().setCategoryName("Fruit");

        when(productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(entry1, entry2)).thenReturn(products);

        // Act
        List<Product> actualProducts = productDao.findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(entry1, entry2);

        // Assert
        assertEquals(products.size(), actualProducts.size());
    }
}
