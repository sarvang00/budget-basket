package com.dal.PFE.controller;

import com.dal.PFE.model.Inventory;
import com.dal.PFE.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;


    @PostMapping({"/saveProductsInInventory"})
    public Inventory saveProductsInInventory(@RequestBody Inventory inventory){
        List<Inventory> expiryDatesProducts = inventoryService.setExpiryDates(Arrays.asList(inventory));
        return inventoryService.saveProductsInInventory(expiryDatesProducts.get(0));

    }

    @PostMapping({"/saveScannedProductsInInventory"})
    public void saveScannedProductsInInventory(@RequestBody List<Inventory> scannedProducts){

        List<Inventory> expiryDatesProducts = inventoryService.setExpiryDates(scannedProducts);

        for (int i = 0; i < expiryDatesProducts.size(); i++) {

            System.out.println(scannedProducts.get(i).getProductName()+":");


            System.out.println(scannedProducts.get(i).getExpiryDate());

        }

        inventoryService.saveScannedProductsInInventory(expiryDatesProducts);


    }

    @GetMapping({"/getInventory"})
    public List<Inventory> getInventoryFromEmail(@RequestParam(value="user",defaultValue = "") String email){
        return inventoryService.getInventoryFromEmail(email);
    }

    @GetMapping({"/getExpiryInventory"})
    public List<Inventory> getExpiryInventoryFromEmail(@RequestParam(value="user",defaultValue = "") String email){
        return inventoryService.getExpiryInventoryFromEmail(email);
    }
}
