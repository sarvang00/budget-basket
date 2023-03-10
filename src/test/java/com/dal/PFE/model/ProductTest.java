package com.dal.PFE.model;

import com.dal.PFE.FinancialEconomizerBackendApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = FinancialEconomizerBackendApplication.class)

public class ProductTest {
    @Test
    public void testingGettersAndSetters() {
        // Arrange
        Product product = new Product(101L, "TestProduct");
        product.setId(101L);
        product.setName("TestProduct");

        //Assert
        assertNotNull(product.getId());
        assertNotNull(product.getName());
        assertEquals(101L, product.getId());
        assertEquals("TestProduct", product.getName());
    }
}
