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
            switch (product.getProductCategory().toLowerCase()) {
                case "dairy":
                case "bakery":
                case "vegetable":
                case "fruit":
                case "beverages":
                    //EXPIRY_PERIOD = 3 hard coded
                    int EXPIRY_PERIOD1 = 3;
                    product.setExpiryDate(DateUtils.addDays(product.getPurchaseDate(), EXPIRY_PERIOD1));
                    break;
                case "beef":
                case "chicken":
                case "fish":
                case "pork":
                case "turkey":
                case "salami":
                    //EXPIRY_PERIOD = 5 hard coded
                    int EXPIRY_PERIOD2 = 5;
                    product.setExpiryDate(DateUtils.addDays(product.getPurchaseDate(), EXPIRY_PERIOD2));
                    break;
                case "baking supplies":
                case "condiments":
                case "canned goods":
                case "cereal":
                case "chips and snacks":
                case "frozen food":
                case "pasta":
                case "nuts":
                case "spices":
                case "seasonings":
                case "soups":
                case "grains":
                case "oils":
                    //EXPIRY_PERIOD = 7 hard coded
                    int EXPIRY_PERIOD3 = 7;
                    product.setExpiryDate(DateUtils.addDays(product.getPurchaseDate(), EXPIRY_PERIOD3));
                    break;
                default:
                    //EXPIRY_PERIOD = 6 hard coded
                    int EXPIRY_PERIOD4 = 6;
                    product.setExpiryDate(DateUtils.addDays(product.getPurchaseDate(), EXPIRY_PERIOD4));
                    break;
            }
        }
        return scannedProducts;
    }

    @Override
    public void saveScannedProductsInInventory(List<Inventory> scannedProducts) {
        inventoryRepository.saveAll(scannedProducts);
    }

    @Override
    public List<Inventory> getExpiryInventoryFromEmail(String email) {
        return inventoryRepository.getExpiryInventoryFromEmail(email);
    }

}
