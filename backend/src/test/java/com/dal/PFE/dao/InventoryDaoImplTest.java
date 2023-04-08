package com.dal.PFE.dao;

import com.dal.PFE.model.Inventory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class InventoryDaoImplTest {
    @Mock
    private InventoryDao inventoryDao;


    @Test
    void testSaveProductsInInventory() {
        Inventory inventory = new Inventory();
        inventory.setProductName("Milk");
        inventory.setProductCategory("dairy");
        inventory.setPurchaseDate(new Date());

        // Setting up mock behavior
        when(inventoryDao.saveProductsInInventory(any(Inventory.class))).thenReturn(inventory);

        Inventory savedInventory = inventoryDao.saveProductsInInventory(inventory);
        savedInventory.setProductId(1);

        verify(inventoryDao).saveProductsInInventory(inventory);
        assertEquals(1, savedInventory.getProductId());
    }

    @Test
    public void testGetInventoryFromEmail() {
        Inventory inventory = new Inventory();
        inventory.setUserEmail("user@test.com");
        inventory.setProductCategory("beef");
        inventory.setProductName("Ground beef");
        inventory.setPurchaseDate(new Date());
        inventory.setProductQuantity(1);

        List<Inventory> inventoryList = new ArrayList<>();
        inventoryList.add(inventory);

        when(inventoryDao.getInventoryFromEmail(anyString())).thenReturn(inventoryList);

        List<Inventory> result = inventoryDao.getInventoryFromEmail("user@test.com");

        verify(inventoryDao, times(1)).getInventoryFromEmail("user@test.com");
        assertEquals(1, result.size());
    }

    @Test
    public void testSetExpiryDates() {
        Inventory inventory = new Inventory();
        inventory.setUserEmail("user@test.com");
        inventory.setProductCategory("beef");
        inventory.setProductName("Ground beef");
        inventory.setPurchaseDate(new Date());
        inventory.setProductQuantity(1);

        List<Inventory> scannedProducts = new ArrayList<>();
        scannedProducts.add(inventory);

        InventoryDao inventoryDaoMock = Mockito.mock(InventoryDao.class);

        List<Inventory> productsWithExpiryDates = new ArrayList<>();
        Inventory inventoryWithExpiryDate = new Inventory();
        inventoryWithExpiryDate.setExpiryDate(new Date());
        productsWithExpiryDates.add(inventoryWithExpiryDate);
        Mockito.when(inventoryDaoMock.setExpiryDates(scannedProducts)).thenReturn(productsWithExpiryDates);

        List<Inventory> result = inventoryDaoMock.setExpiryDates(scannedProducts);

        assertNotNull(result.get(0).getExpiryDate());
    }


    @Test
    public void testSaveScannedProductsInInventory() {
        Inventory inventory = new Inventory();
        inventory.setUserEmail("user@test.com");
        inventory.setProductCategory("beef");
        inventory.setProductName("Ground beef");
        inventory.setPurchaseDate(new Date());
        inventory.setProductQuantity(1);

        List<Inventory> scannedProducts = new ArrayList<>();
        scannedProducts.add(inventory);

        doNothing().when(inventoryDao).saveScannedProductsInInventory(scannedProducts);

        inventoryDao.saveScannedProductsInInventory(scannedProducts);

        verify(inventoryDao).saveScannedProductsInInventory(scannedProducts);
    }

}
