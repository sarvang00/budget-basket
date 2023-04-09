package com.dal.PFE.service;

import com.dal.PFE.dao.InventoryDao;
import com.dal.PFE.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    @Override
    @Transactional
    public Inventory saveProductsInInventory(Inventory inventory) {

        return inventoryDao.saveProductsInInventory(inventory);
    }

    @Override
    @Transactional
    public List<Inventory> getInventoryFromEmail(String email) {
        return inventoryDao.getInventoryFromEmail(email);
    }

    @Override
    @Transactional
    public void saveScannedProductsInInventory(List<Inventory> scannedProducts) {
        inventoryDao.saveScannedProductsInInventory(scannedProducts);
    }

    @Override
    @Transactional
    public List<Inventory> setExpiryDates(List<Inventory> scannedProducts) {

        return inventoryDao.setExpiryDates(scannedProducts);
    }

    @Override
    public List<Inventory> getExpiryInventoryFromEmail(String email) {
        return inventoryDao.getExpiryInventoryFromEmail(email);
    }
}
