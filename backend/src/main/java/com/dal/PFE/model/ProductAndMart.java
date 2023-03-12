package com.dal.PFE.model;


public class ProductAndMart {

    Product searchedProduct;

    Kroger searchedKrogerProduct;

    Aide searchedAideProduct;

    TraderJoe searchedTraderJoeProduct;

    public ProductAndMart(){}

    public ProductAndMart(Product searchedProduct, Kroger searchedKrogerProduct, Aide searchedAideProduct, TraderJoe searchedTraderJoeProduct) {
        this.searchedProduct = searchedProduct;
        this.searchedKrogerProduct = searchedKrogerProduct;
        this.searchedAideProduct = searchedAideProduct;
        this.searchedTraderJoeProduct = searchedTraderJoeProduct;
    }

    public Product getSearchedProduct() {
        return searchedProduct;
    }

    public void setSearchedProduct(Product searchedProduct) {
        this.searchedProduct = searchedProduct;
    }

    public Kroger getSearchedKrogerProduct() {
        return searchedKrogerProduct;
    }

    public void setSearchedKrogerProduct(Kroger searchedKrogerProduct) {
        this.searchedKrogerProduct = searchedKrogerProduct;
    }

    public Aide getSearchedAideProduct() {
        return searchedAideProduct;
    }

    public void setSearchedAideProduct(Aide searchedAideProduct) {
        this.searchedAideProduct = searchedAideProduct;
    }

    public TraderJoe getSearchedTraderJoeProduct() {
        return searchedTraderJoeProduct;
    }

    public void setSearchedTraderJoeProduct(TraderJoe searchedTraderJoeProduct) {
        this.searchedTraderJoeProduct = searchedTraderJoeProduct;
    }
}
