package com.dal.PFE.repository;

import com.dal.PFE.model.Kroger;
import com.dal.PFE.model.TraderJoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TraderJoeRepository extends JpaRepository<TraderJoe,Integer> {


    @Query("from TraderJoe as p where p.productId=?1")
    List<TraderJoe> findTheProductsByIdFromTraderJoe(int id);
}
