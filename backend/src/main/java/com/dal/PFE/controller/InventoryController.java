package com.dal.PFE.controller;

import com.dal.PFE.dao.InventoryDao;
import com.dal.PFE.model.Inventory;
import com.dal.PFE.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;


    @PostMapping({"/saveProductsInInventory"})
    public Inventory saveProductsInInventory(@RequestBody Inventory inventory){
        return inventoryService.saveProductsInInventory(inventory);

    }

    @GetMapping({"/getInventory"})
    public List<Inventory> getInventoryFromEmail(@RequestBody String email){
        return inventoryService.getInventoryFromEmail(email);
    }
}
