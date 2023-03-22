package com.dal.PFE.controller;

import com.dal.PFE.dao.InventoryDao;
import com.dal.PFE.model.Inventory;
import com.dal.PFE.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;


    @PostMapping({"/saveProductsInInventory"})
    public Inventory saveProductsInInventory(@RequestBody Inventory inventory, @RequestBody int userId){
        inventory.setUserId(userId);
        return inventoryService.saveProductsInInventory(inventory);

    }
}
