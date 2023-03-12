package com.dal.PFE.dao;

import com.dal.PFE.model.Kroger;
import com.dal.PFE.model.Mart;
import com.dal.PFE.model.Product;
import com.dal.PFE.model.ProductAndMart;
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

    public List<ProductAndMart> getAllSearchedProducts(String keyword){

        List<Product> searchedProductList = productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(keyword,keyword);

        for (int i = 0; i < searchedProductList.size(); i++) {

            System.out.print(searchedProductList.get(i).getId()+"-"+searchedProductList.get(i).getName()+"\n");

        }

        List<ProductAndMart> searchResultList = new ArrayList<>();
        for (int i = 0; i < searchedProductList.size(); i++) {
            Long productId = searchedProductList.get(i).getId();
            System.out.print("prod id : "+ productId);
            ProductAndMart tempProductAndMart = new ProductAndMart();

            tempProductAndMart.setSearchedProduct(searchedProductList.get(i));
            Kroger tempKroger =  krogerRepository.findTheProductsByIdFromKroger(productId.intValue()).get(0);
            System.out.println(tempKroger.toString());
            tempProductAndMart.setSearchedKrogerProduct(tempKroger);
            tempProductAndMart.setSearchedAideProduct(aideRepository.findTheProductsByIdFromAide(productId.intValue()).get(0));
            tempProductAndMart.setSearchedTraderJoeProduct(traderJoeRepository.findTheProductsByIdFromTraderJoe(productId.intValue()).get(0));

            searchResultList.add(tempProductAndMart);
        }

        return searchResultList;
    }

    public List<Product> findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(String entry1, String entry2) {
        return productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(entry1, entry2);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
    public List<Mart> findAllProductsByIDFromAllStores(int id){
        List<Mart> allSearchedProducts = new ArrayList<>();
        List<Mart> allSearchedProductsFromKroger = new ArrayList<>();
        List<Mart> allSearchedProductsFromAide = new ArrayList<>();
        List<Mart> allSearchedProductsFromTraderJoe = new ArrayList<>();




        return  allSearchedProducts;
    }

}
