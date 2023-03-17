package com.dal.PFE.dao;

import com.dal.PFE.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDao extends CrudRepository<Inventory,Integer> {
}
