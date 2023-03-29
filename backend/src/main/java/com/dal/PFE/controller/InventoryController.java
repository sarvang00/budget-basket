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

    @PostMapping({"/saveScannedProductsInInventory"})
    public Inventory saveScannedProductsInInventory(@RequestBody List<Inventory> scannedProducts){

        List<Inventory> scannedProductsWithExpiryDates = inventoryService.setExpiryDates(scannedProducts);

        for (int i = 0; i < scannedProductsWithExpiryDates.size(); i++) {

            System.out.println(scannedProducts.get(i).getProductName()+":");


            System.out.println(scannedProducts.get(i).getExpiryDate());

        }

        return null;

    }

    @GetMapping({"/getInventory"})
    public List<Inventory> getInventoryFromEmail(@RequestParam(value="user",defaultValue = "") String email){
        return inventoryService.getInventoryFromEmail(email);
    }
}
