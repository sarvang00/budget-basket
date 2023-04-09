package com.dal.PFE.controller;

import com.dal.PFE.model.Inventory;
import com.dal.PFE.service.InventoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
@SpringBootTest
class InventoryControllerTest {

    @InjectMocks
    InventoryController inventoryController;

    @Mock
    InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveProductsInInventory() {
        Inventory inventory = new Inventory(
                1,
                "Test Product",
                "Test Category",
                5,
                10.0,
                new Date(),
                new Date(),
                "test@example.com"
        );
        when(inventoryService.saveProductsInInventory(any())).thenReturn(inventory);

        Inventory result = inventoryController.saveProductsInInventory(inventory);

        verify(inventoryService, times(1)).saveProductsInInventory(any());
        assert result != null;
        assert result.getProductId() == 1;
        assert result.getProductName().equals("Test Product");
        assert result.getProductCategory().equals("Test Category");
        assert result.getProductQuantity() == 5;
        assert result.getProductPrice() == 10.0;
        assert result.getPurchaseDate() != null;
        assert result.getExpiryDate() != null;
        assert result.getUserEmail().equals("test@example.com");
    }

    @Test
    void saveScannedProductsInInventory() {
        List<Inventory> scannedProducts = new ArrayList<>();
        scannedProducts.add(new Inventory(
                1,
                "Test Product 1",
                "Test Category",
                5,
                10.0,
                new Date(),
                null,
                "test@example.com"
        ));
        scannedProducts.add(new Inventory(
                2,
                "Test Product 2",
                "Test Category",
                10,
                15.0,
                new Date(),
                null,
                "test@example.com"
        ));
        when(inventoryService.setExpiryDates(any())).thenReturn(scannedProducts);

        inventoryController.saveScannedProductsInInventory(scannedProducts);

        verify(inventoryService, times(1)).setExpiryDates(any());
        verify(inventoryService, times(1)).saveScannedProductsInInventory(any());
    }

    @Test
    void getInventoryFromEmail() {
        List<Inventory> inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory(
                1,
                "Test Product 1",
                "Test Category",
                5,
                10.0,
                new Date(),
                null,
                "test@example.com"
        ));
        when(inventoryService.getInventoryFromEmail(anyString())).thenReturn(inventoryList);

        List<Inventory> result = inventoryController.getInventoryFromEmail("test@example.com");

        verify(inventoryService, times(1)).getInventoryFromEmail(anyString());
        assert result.size() == 1;
        Inventory inventory = result.get(0);
        assert inventory.getProductId() == 1;
        assert inventory.getProductName().equals("Test Product 1");
        assert inventory.getProductCategory().equals("Test Category");
        assert inventory.getProductQuantity() == 5;
        assert inventory.getProductPrice() == 10.0;
        assert inventory.getPurchaseDate() != null;
        assert inventory.getExpiryDate() == null;
        assert inventory.getUserEmail().equals("test@example.com");
    }
}