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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
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
    public void testGetCategoryByName() throws Exception {
        // Arrange
        String categoryName = "TestCategory";
        Category category = new Category();
        category.setCategoryName(categoryName);
        when(categoryService.getCategoryByName(categoryName)).thenReturn(category);

        String endpoint = "/category/getCategoryByName";
        String paramName = "categoryName";
        String paramValue = categoryName;
        MediaType contentType = MediaType.APPLICATION_JSON;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(endpoint);
        requestBuilder.param(paramName, paramValue);
        requestBuilder.contentType(contentType);

        // Act
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        // Assert
        ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
        ResultMatcher categoryNameMatcher = MockMvcResultMatchers.jsonPath("$.categoryName").value(categoryName);
        resultActions.andExpect(statusMatcher);
        resultActions.andExpect(categoryNameMatcher);
    }


}

