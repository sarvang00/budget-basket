package com.dal.PFE.dao;

import com.dal.PFE.model.Category;
import com.dal.PFE.model.Kroger;
import com.dal.PFE.model.Product;
import com.dal.PFE.model.ProductAndMart;
import com.dal.PFE.repository.AideRepository;
import com.dal.PFE.repository.KrogerRepository;
import com.dal.PFE.repository.ProductRepository;
import com.dal.PFE.repository.TraderJoeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductDaoImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private KrogerRepository krogerRepository;

    @Mock
    private AideRepository aideRepository;

    @Mock
    private TraderJoeRepository traderJoeRepository;

    @InjectMocks
    private ProductDaoImpl productDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllSearchedProducts() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Product 1");
        product1.setCategory(new Category());

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Product 2");
        product2.setCategory(new Category());

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase("keyword", "keyword"))
                .thenReturn(productList);

        List<Kroger> krogerProducts = new ArrayList<>();
        Kroger krogerProduct = new Kroger();
        krogerProduct.setProductId(1);
        krogerProducts.add(krogerProduct);

        when(krogerRepository.findTheProductsByIdFromKroger(1)).thenReturn(krogerProducts);
        when(aideRepository.findTheProductsByIdFromAide(1)).thenReturn(new ArrayList<>());
        when(traderJoeRepository.findTheProductsByIdFromTraderJoe(1)).thenReturn(new ArrayList<>());

        List<ProductAndMart> expectedSearchResultList = new ArrayList<>();
        ProductAndMart expectedProductAndMart1 = new ProductAndMart();
        expectedProductAndMart1.setSearchedProduct(product1);
        expectedProductAndMart1.setSearchedKrogerProduct(krogerProduct);
        expectedProductAndMart1.setSearchedAideProduct(null);
        expectedProductAndMart1.setSearchedTraderJoeProduct(null);
        expectedSearchResultList.add(expectedProductAndMart1);

        ProductAndMart expectedProductAndMart2 = new ProductAndMart();
        expectedProductAndMart2.setSearchedProduct(product2);
        expectedProductAndMart2.setSearchedKrogerProduct(null);
        expectedProductAndMart2.setSearchedAideProduct(null);
        expectedProductAndMart2.setSearchedTraderJoeProduct(null);
        expectedSearchResultList.add(expectedProductAndMart2);

        List<ProductAndMart> actualSearchResultList = productDao.getAllSearchedProducts("keyword");

        assertEquals(expectedSearchResultList.size(), actualSearchResultList.size());
        for (int i = 0; i < expectedSearchResultList.size(); i++) {
            ProductAndMart expected = expectedSearchResultList.get(i);
            ProductAndMart actual = actualSearchResultList.get(i);
            assertEquals(expected.getSearchedProduct().getId(), actual.getSearchedProduct().getId());
            assertEquals(expected.getSearchedProduct().getName(), actual.getSearchedProduct().getName());
            assertEquals(expected.getSearchedKrogerProduct(), actual.getSearchedKrogerProduct());
            assertEquals(expected.getSearchedAideProduct(), actual.getSearchedAideProduct());
            assertEquals(expected.getSearchedTraderJoeProduct(), actual.getSearchedTraderJoeProduct());
        }
    }





    @Test
    public void testFindByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase() {
        // Arrange
        String entry1 = "apple";
        String entry2 = "fruit";

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Apple"));
        products.get(0).setCategory(new Category());
        products.get(0).getCategory().setCategoryName("Fruit");
        products.add(new Product(2, "Orange"));
        products.get(1).setCategory(new Category());
        products.get(1).getCategory().setCategoryName("Fruit");

        when(productRepository.findByProductNameContainingIgnoreCaseOrCategory_CategoryNameContainingIgnoreCase(entry1, entry2)).thenReturn(products);

        // Act
        List<Product> actualProducts = productDao.findByProductNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(entry1, entry2);

        // Assert
        assertEquals(products.size(), actualProducts.size());
    }
}
