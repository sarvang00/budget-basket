package com.dal.PFE.repository;

import com.dal.PFE.model.Aide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AideRepository extends JpaRepository<Aide,Integer> {
    @Query("from Aide as p where p.productId=?1")
    List<Aide> findTheProductsByIdFromAide(int id);
}
