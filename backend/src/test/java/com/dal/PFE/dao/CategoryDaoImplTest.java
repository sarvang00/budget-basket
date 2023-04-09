package com.dal.PFE.dao;

import com.dal.PFE.model.Category;
import com.dal.PFE.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryDaoImplTest {

    @Autowired
    private CategoryDao categoryDao;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void testFindByCategoryNameIgnoreCase() {
        // Arrange
        String categoryName = "Fruits";
        Category expectedCategory = new Category();
        when(categoryRepository.findByCategoryNameIgnoreCase(categoryName)).thenReturn(expectedCategory);

        // Act
        Category actualCategory = categoryDao.findByCategoryNameIgnoreCase(categoryName);

        // Assert
        assertEquals(expectedCategory, actualCategory);
    }

}

