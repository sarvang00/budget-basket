package com.dal.PFE.dao;

import com.dal.PFE.model.Inventory;

import java.util.List;

public interface InventoryDao {


    Inventory saveProductsInInventory(Inventory inventory);

    List<Inventory> getInventoryFromEmail(String email);
}
