package com.dal.PFE.service;

import com.dal.PFE.dao.MartDao;
import com.dal.PFE.model.Aide;
import com.dal.PFE.model.Kroger;
import com.dal.PFE.model.TraderJoe;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MartServiceImplTest {
    @InjectMocks
    private MartServiceImpl martService;

    @Mock
    private MartDao martDao;

    @Test
    public void testGetAllProductFromKroger() {
        List<Kroger> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Kroger());
        expectedProducts.add(new Kroger());

        // Mocking the behavior of martDao.getAllProductFromKroger() method
        when(martDao.getAllProductFromKroger()).thenReturn(expectedProducts);

        // Arrange
        List<Kroger> actualProducts = martService.getAllProductFromKroger();

        // Assert
        assertEquals(expectedProducts, actualProducts);
        verify(martDao).getAllProductFromKroger();
    }

    @Test
    public void testGetAllProductFromAide() {

        List<Aide> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Aide());
        expectedProducts.add(new Aide());

        // Mocking the behavior of martDao.getAllProductFromAide() method
        when(martDao.getAllProductFromAide()).thenReturn(expectedProducts);

        // Arrange
        List<Aide> actualProducts = martService.getAllProductFromAide();

        // Assert
        assertEquals(expectedProducts, actualProducts);
        verify(martDao).getAllProductFromAide();
    }

    @Test
    public void testGetAllProductFromTraderJoe() {

        List<TraderJoe> expectedProducts = new ArrayList<>();
        expectedProducts.add(new TraderJoe());
        expectedProducts.add(new TraderJoe());

        // Mocking the behavior of martDao.getAllProductFromTraderJoe() method
        when(martDao.getAllProductFromTraderJoe()).thenReturn(expectedProducts);

        // Arrange
        List<TraderJoe> actualProducts = martService.getAllProductFromTraderJoe();

        // Assert
        assertEquals(expectedProducts, actualProducts);
        verify(martDao).getAllProductFromTraderJoe();
    }
}

