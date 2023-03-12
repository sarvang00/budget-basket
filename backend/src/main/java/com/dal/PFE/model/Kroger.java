package com.dal.PFE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "kroger")
public class Kroger {

    @Id
    @Column(name = "mart_prod_id")
    int martProdId;

    @Column(name = "product_id")
    int productId;

    @Column(name = "product_price")
    double productPrice;

    @Column(name = "price_quantity")
    double priceQuantity;

    @Column(name = "quantity_unit")
    String unit;

    @Column(name = "product_description")
    String productDescription;

    @Column(name = "product_availability")
    boolean productAvailability;

    public Kroger(int martProdId, int productId, double productPrice, double priceQuantity, String unit, String productDescription, boolean productAvailability) {
        this.martProdId = martProdId;
        this.productId = productId;
        this.productPrice = productPrice;
        this.priceQuantity = priceQuantity;
        this.unit = unit;
        this.productDescription = productDescription;
        this.productAvailability = productAvailability;
    }

    public Kroger() {
    }

    public int getMartProdId() {
        return martProdId;
    }

    public void setMartProdId(int martProdId) {
        this.martProdId = martProdId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getPriceQuantity() {
        return priceQuantity;
    }

    public void setPriceQuantity(double priceQuantity) {
        this.priceQuantity = priceQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public boolean isProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(boolean productAvailability) {
        this.productAvailability = productAvailability;
    }
}
