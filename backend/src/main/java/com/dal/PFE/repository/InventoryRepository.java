package com.dal.PFE.repository;

import com.dal.PFE.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    @Query("from Inventory as i where p.userEmail=?1")
    List<Inventory> getInventoryFromEmail(String email);
}
