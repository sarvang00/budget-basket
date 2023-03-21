package com.dal.PFE.service;

import com.dal.PFE.dao.InventoryDao;
import com.dal.PFE.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    public Inventory saveProductsInInventory(Inventory inventory) {

        return inventoryDao.saveProductsInInventory(inventory);
    }
}
