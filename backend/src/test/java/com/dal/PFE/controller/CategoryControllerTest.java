package com.dal.PFE.controller;

import com.dal.PFE.FinancialEconomizerBackendApplication;
import com.dal.PFE.model.Category;
import com.dal.PFE.service.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = FinancialEconomizerBackendApplication.class)
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testingGetCategoryByName() throws Exception {
        Category category = new Category();
        category.setCategoryName("TestCategory");

        when(categoryService.getCategoryByName("TestCategory")).thenReturn(category);

        mockMvc.perform(MockMvcRequestBuilders.get("/category/getCategoryByName")
                        .param("categoryName", "TestCategory")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.categoryName").value("TestCategory"));
    }
}
