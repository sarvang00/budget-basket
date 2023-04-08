package com.dal.PFE.dao;

import com.dal.PFE.model.*;
import com.dal.PFE.repository.AideRepository;
import com.dal.PFE.repository.KrogerRepository;
import com.dal.PFE.repository.ProductRepository;
import com.dal.PFE.repository.TraderJoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    KrogerRepository krogerRepository;

    @Autowired
    AideRepository aideRepository;

    @Autowired
    TraderJoeRepository traderJoeRepository;

    //Refactored Code
    public List<ProductAndMart> getAllSearchedProducts(String keyword) {

        List<Product> searchedProductList = productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(keyword, keyword);

        List<ProductAndMart> searchResultList = new ArrayList<>();
        for (Product product : searchedProductList) {
            Long productId = product.getId();
            System.out.print("prod id : " + productId + "\n");

            ProductAndMart tempProductAndMart = new ProductAndMart();
            tempProductAndMart.setSearchedProduct(product);
            System.out.println(tempProductAndMart.getSearchedProduct().toString());

            List<Kroger> krogerProducts = krogerRepository.findTheProductsByIdFromKroger(productId.intValue());
            tempProductAndMart.setSearchedKrogerProduct(krogerProducts.isEmpty() ? null : krogerProducts.get(0));

            List<Aide> aideProducts = aideRepository.findTheProductsByIdFromAide(productId.intValue());
            tempProductAndMart.setSearchedAideProduct(aideProducts.isEmpty() ? null : aideProducts.get(0));

            List<TraderJoe> traderJoeProducts = traderJoeRepository.findTheProductsByIdFromTraderJoe(productId.intValue());
            tempProductAndMart.setSearchedTraderJoeProduct(traderJoeProducts.isEmpty() ? null : traderJoeProducts.get(0));

            searchResultList.add(tempProductAndMart);
        }

        return searchResultList;
    }

/*
    // this one is ORIGINAL
    public List<ProductAndMart> getAllSearchedProducts(String keyword){

        List<Product> searchedProductList = productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(keyword,keyword);

        for (int i = 0; i < searchedProductList.size(); i++) {

            System.out.print(searchedProductList.get(i).getId()+"-"+searchedProductList.get(i).getName()+"\n");

        }
        System.out.println("size of searchedProductList : "+searchedProductList.size());
        List<ProductAndMart> searchResultList = new ArrayList<>();
        for (int i = 0; i < searchedProductList.size(); i++) {
            Long productId = searchedProductList.get(i).getId();
            System.out.print("prod id : "+ productId+"\n");
            ProductAndMart tempProductAndMart = new ProductAndMart();

            tempProductAndMart.setSearchedProduct(searchedProductList.get(i));
            System.out.println(tempProductAndMart.getSearchedProduct().toString());

            if(krogerRepository.findTheProductsByIdFromKroger(productId.intValue()).size()!=0) {
                tempProductAndMart.setSearchedKrogerProduct(krogerRepository.findTheProductsByIdFromKroger(productId.intValue()).get(0));
            }else {
                tempProductAndMart.setSearchedKrogerProduct(null);
            }
            if (aideRepository.findTheProductsByIdFromAide(productId.intValue()).size()!=0) {
                tempProductAndMart.setSearchedAideProduct(aideRepository.findTheProductsByIdFromAide(productId.intValue()).get(0));
            }else {
                tempProductAndMart.setSearchedAideProduct(null);
            }

            if (traderJoeRepository.findTheProductsByIdFromTraderJoe(productId.intValue()).size()!=0){
                tempProductAndMart.setSearchedTraderJoeProduct(traderJoeRepository.findTheProductsByIdFromTraderJoe(productId.intValue()).get(0));
            }else {
                tempProductAndMart.setSearchedTraderJoeProduct(null);
            }
            searchResultList.add(tempProductAndMart);
        }
        return searchResultList;
    }

 */

    public List<Product> findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(String entry1, String entry2) {
        return productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(entry1, entry2);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }


}
