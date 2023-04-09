package com.dal.PFE.service;

import com.dal.PFE.model.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory saveProductsInInventory(Inventory inventory);

    List<Inventory> getInventoryFromEmail(String email);

    void saveScannedProductsInInventory(List<Inventory> scannedProducts);


    List<Inventory> setExpiryDates(List<Inventory> scannedProducts);

    List<Inventory> getExpiryInventoryFromEmail(String email);
}
