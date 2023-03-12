package com.dal.PFE.model;

import com.dal.PFE.FinancialEconomizerBackendApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(classes = FinancialEconomizerBackendApplication.class)

public class CategoryTest {

    @Test
    public void testingGettersAndSetters() {
        Category category = new Category();
        category.setCategoryId(202L);
        category.setCategoryName("TestCategory");
        assertNotNull(category.getCategoryId());
        assertNotNull(category.getCategoryName());
        assertEquals(202L, category.getCategoryId());
        assertEquals("TestCategory", category.getCategoryName());
    }


}

