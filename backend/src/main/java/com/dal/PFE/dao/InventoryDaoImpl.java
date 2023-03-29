package com.dal.PFE.dao;

import com.dal.PFE.model.Inventory;
import com.dal.PFE.repository.InventoryRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDaoImpl implements InventoryDao {

    @Autowired
    InventoryRepository inventoryRepository;


    @Override
    public Inventory saveProductsInInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getInventoryFromEmail(String email) {
        return inventoryRepository.getInventoryFromEmail(email);
    }

    @Override
    public List<Inventory> setExpiryDates(List<Inventory> scannedProducts) {
        for (Inventory product : scannedProducts) {
            // Set the expiry date based on the product category
            switch (product.getProductCategory()) {
                case "dairy":
                case "bakery":
                case "vegetable":
                case "fruites":
                case "beverages":
                    product.setExpiryDate(DateUtils.addDays(product.getPurchaseDate(), 3));
                    break;
                case "beef":
                case "chicken":
                case "fish":
                case "pork":
                case "turkey":
                case "salami":
                    product.setExpiryDate(DateUtils.addDays(product.getPurchaseDate(), 5));
                    break;
                case "baking supplies":
                case "condiments":
                case "canned goods":
                case "cereal":
                case "chips and snacks":
                case "frozen foods":
                case "pasta":
                case "nuts":
                case "spices":
                case "seasonings":
                case "soups":
                case "grains":
                case "oils":
                    product.setExpiryDate(DateUtils.addDays(product.getPurchaseDate(), 7));
                    break;
                default:
                    // Unknown category, set expiry date to null
                    product.setExpiryDate(null);
                    break;
            }
        }
        return scannedProducts;
    }

}
