package com.dal.PFE.repository;

import com.dal.PFE.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    @Query("from Inventory as i where i.userEmail=?1")
    List<Inventory> getInventoryFromEmail(String email);


    @Query("from Inventory as i where i.userEmail=?1 and i.expiryDate < DATEADD(day,+2,current_date()) and i.expiryDate > DATEADD(day,-2,current_date())")
    List<Inventory> getExpiryInventoryFromEmail(String email);

}
