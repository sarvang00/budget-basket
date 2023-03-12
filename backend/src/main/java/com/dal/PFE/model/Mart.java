package com.dal.PFE.model;

public interface Mart {

    int getMartProdId();
    void setMartProdId(int martProdId);
    int getProductId();
    void setProductId(int productId);
    double getProductPrice();
    void setProductPrice(double productPrice);
    double getPriceQuantity();
    void setPriceQuantity(double priceQuantity);
    String getUnit();
    void setUnit(String unit);
    String getProductDescription();
    void setProductDescription(String productDescription);
    boolean isProductAvailability();
    void setProductAvailability(boolean productAvailability);
}
