package com.dal.PFE.service;

import com.dal.PFE.model.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory saveProductsInInventory(Inventory inventory);

    List<Inventory> getInventoryFromEmail(String email);

    Inventory saveScaneedProductsInInventory(List<Inventory> scannedProducts);


    List<Inventory> setExpiryDates(List<Inventory> scannedProducts);
}
