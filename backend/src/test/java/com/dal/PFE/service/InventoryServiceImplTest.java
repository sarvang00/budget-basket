package com.dal.PFE.service;

import com.dal.PFE.dao.InventoryDao;
import com.dal.PFE.model.Inventory;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;

@SpringBootTest
public class InventoryServiceImplTest {

    @Mock
    private InventoryDao inventoryDao;

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @Test
    public void testSaveProductsInInventory() {
        Inventory inventory = new Inventory();
        when(inventoryDao.saveProductsInInventory(inventory)).thenReturn(inventory);
        Inventory savedInventory = inventoryService.saveProductsInInventory(inventory);
        assertEquals(inventory, savedInventory);
    }

    @Test
    public void testGetInventoryFromEmail() {
        List<Inventory> inventoryList = new ArrayList<>();
        when(inventoryDao.getInventoryFromEmail("test@test.com")).thenReturn(inventoryList);
        List<Inventory> fetchedInventoryList = inventoryService.getInventoryFromEmail("test@test.com");
        assertEquals(inventoryList, fetchedInventoryList);
    }

    @Test
    public void testSaveScannedProductsInInventory() {
        List<Inventory> scannedProducts = new ArrayList<>();
        inventoryService.saveScannedProductsInInventory(scannedProducts);
    }

    @Test
    public void testSetExpiryDates() {
        List<Inventory> scannedProducts = new ArrayList<>();
        List<Inventory> inventoryList = new ArrayList<>();
        when(inventoryDao.setExpiryDates(scannedProducts)).thenReturn(inventoryList);
        List<Inventory> fetchedInventoryList = inventoryService.setExpiryDates(scannedProducts);
        assertEquals(inventoryList, fetchedInventoryList);
    }

    @Test
    public void testSaveProductsInInventoryWithData() {
        // Arrange
        Date date = new Date();
        Inventory inventory = new Inventory(1, "Milk", "dairy", 2, 1.5, date, null, "test@test.com");
        Mockito.when(inventoryDao.saveProductsInInventory(inventory)).thenReturn(inventory);

        // Act
        Inventory result = inventoryService.saveProductsInInventory(inventory);

        // Assert
        Assert.assertEquals(inventory, result);
    }

    @Test
    public void testGetInventoryFromEmailWithData() {
        // Arrange
        Date date = new Date();
        List<Inventory> inventoryList = new ArrayList<>();
        Inventory inventory1 = new Inventory(1, "Milk", "dairy", 2, 1.5, date, null, "test@test.com");
        Inventory inventory2 = new Inventory(2, "Bread", "bakery", 1, 2.0, date, null, "test@test.com");
        inventoryList.add(inventory1);
        inventoryList.add(inventory2);

        Mockito.when(inventoryDao.getInventoryFromEmail("test@test.com")).thenReturn(inventoryList);

        // Act
        List<Inventory> result = inventoryService.getInventoryFromEmail("test@test.com");

        // Assert
        Assert.assertEquals(inventoryList, result);
    }

    @Test
    public void testSaveScannedProductsInInventoryWithData() {
        // Arrange
        List<Inventory> inventoryList = new ArrayList<>();
        Date date = new Date();
        Inventory inventory1 = new Inventory(1, "Milk", "dairy", 2, 1.5, date, null, "test@test.com");
        Inventory inventory2 = new Inventory(2, "Bread", "bakery", 1, 2.0, date, null, "test@test.com");
        inventoryList.add(inventory1);
        inventoryList.add(inventory2);

        // Act
        inventoryService.saveScannedProductsInInventory(inventoryList);

        // Assert
        Mockito.verify(inventoryDao, Mockito.times(1)).saveScannedProductsInInventory(inventoryList);
    }
}