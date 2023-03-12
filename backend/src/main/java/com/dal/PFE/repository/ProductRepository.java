package com.dal.PFE.repository;

import com.dal.PFE.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(String entry1, String entry2);
}