package com.dal.PFE.service;

import com.dal.PFE.dao.InventoryDao;
import com.dal.PFE.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    public Inventory saveProductsInInventory(Inventory inventory) {

        return inventoryDao.saveProductsInInventory(inventory);
    }

    @Override
    public List<Inventory> getInventoryFromEmail(String email) {
        return inventoryDao.getInventoryFromEmail(email);
    }

    @Override
    public Inventory saveScaneedProductsInInventory(List<Inventory> scannedProducts) {
        return null;
    }

    @Override
    public List<Inventory> setExpiryDates(List<Inventory> scannedProducts) {

        return inventoryDao.setExpiryDates(scannedProducts);
    }
}
