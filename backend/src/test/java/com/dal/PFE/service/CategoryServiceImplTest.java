package com.dal.PFE.service;

import com.dal.PFE.dao.CategoryDaoImpl;
import com.dal.PFE.model.Category;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CategoryServiceImplTest {

    @Mock
    private CategoryDaoImpl categoryDao;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void testGetCategoryByName() {
        String categoryName = "TestCategory";
        Category expectedCategory = new Category();
        expectedCategory.setCategoryName(categoryName);

        when(categoryDao.findByCategoryNameIgnoreCase(categoryName)).thenReturn(expectedCategory);

        Category actualCategory = categoryService.getCategoryByName(categoryName);

        assertEquals(expectedCategory, actualCategory);
        verify(categoryDao).findByCategoryNameIgnoreCase(categoryName);
    }

    @Test
    public void testGetAllCategory() {
        Category category1 = new Category();
        Category category2 = new Category();
        List<Category> expectedCategories = Arrays.asList(category1, category2);

        when(categoryDao.findAll()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getAllCategory();

        assertEquals(expectedCategories, actualCategories);
        verify(categoryDao).findAll();
    }
}

