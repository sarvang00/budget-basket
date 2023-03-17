package com.dal.PFE.controller;

import com.dal.PFE.dao.InventoryDao;
import com.dal.PFE.model.Inventory;
import com.dal.PFE.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private InventoryDao inventoryDao;

    @PostMapping({"/product/saveProductsInInventory"})

    public Inventory saveProductsInInventory(@RequestBody Inventory inventory){
        return inventoryService.saveProductsInInventory(inventory);

    }
}
