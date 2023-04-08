package com.dal.PFE.controller;

import com.dal.PFE.FinancialEconomizerBackendApplication;
import com.dal.PFE.model.Product;
import com.dal.PFE.service.ProductService;
import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = FinancialEconomizerBackendApplication.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetAllProducts() throws Exception {
        // Mocking data
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(101, "TestProduct 1"));
        productList.add(new Product(102, "TestProduct 2"));
        when(productService.getAllProductsIdsSearched("")).thenReturn(productList);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/product/getAllProductsIdsSearched"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        System.out.println("Response status: " + status);
        System.out.println("Response content: " + content);
        String expectedResponse = "[{\"name\":\"TestProduct 1\",\"id\":101},{\"name\":\"TestProduct 2\",\"id\":102}]";
        assertEquals(expectedResponse, content);
    }


}

