package com.dal.PFE.dao;

import com.dal.PFE.model.Inventory;
import com.dal.PFE.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryDaoImpl implements InventoryDao {

    @Autowired
    InventoryRepository inventoryRepository;


    @Override
    public Inventory saveProductsInInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}