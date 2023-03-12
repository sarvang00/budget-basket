package com.dal.PFE.repository;

import com.dal.PFE.model.Kroger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KrogerRepository extends JpaRepository<Kroger,Integer> {


    @Query("from Kroger as p where p.productId=?1")
    List<Kroger> findTheProductsByIdFromKroger(int id);
}
