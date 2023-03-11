package com.dal.PFE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "product_details")
public class Product {
    @Id
    @Column(name = "product_id")
    private Long product_id;
    @Column(name = "product_name")
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"products", "hibernateLazyInitializer", "handler"})
    private Category category;

    public Product(long product_id, String productName) {
        this.product_id = product_id;
        this.productName = productName;
    }


    public Long getId() {
        return product_id;
    }

    public void setId(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

   /* public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }*/
}

