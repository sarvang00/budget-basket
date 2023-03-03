package com.dal.PFE.repository;

import com.dal.PFE.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryNameIgnoreCase(String categoryName);
}
