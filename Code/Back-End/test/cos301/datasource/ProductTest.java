/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cos301.datasource;

import org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 *
 * @author Daniel
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {
    
    @InjectMocks
    Product product = new Product();
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdProduct method, of class Product.
     */
    @Test
    public void testGetIdProduct() {
        System.out.println("getIdProduct");
        when(product.getIdProduct()).thenReturn(10);
        assertEquals(product.getIdProduct(), 10);
    }

    /**
     * Test of setIdProduct method, of class Product.
     */
    @Test
    public void testSetIdProduct_int() {
        System.out.println("setIdProduct");
        product.setIdProduct(10);
        assertEquals(10, product.getIdProduct());
    }

    /**
     * Test of setIdProduct method, of class Product.
     */
    @Test
    public void testSetIdProduct_String() {
        System.out.println("setIdProduct");
        product.setIdProduct("10");
        assertEquals(10, product.getIdProduct());
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        when(product.getProductName()).thenReturn("test");
        assertEquals(product.getProductName(), "test");
    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        product.setProductName("test");
        assertEquals("test", product.getProductName());
    }

    /**
     * Test of getProductPack method, of class Product.
     */
    @Test
    public void testGetProductPack() {
        System.out.println("getProductPack");
        when(product.getProductPack()).thenReturn("test");
        assertEquals(product.getProductPack(), "test");
    }

    /**
     * Test of setProductPack method, of class Product.
     */
    @Test
    public void testSetProductPack() {
        System.out.println("setProductPack");
        product.setProductPack("test");
        assertEquals("test", product.getProductPack());
    }

    /**
     * Test of getProductDescription method, of class Product.
     */
    @Test
    public void testGetProductDescription() {
        System.out.println("getProductDescription");
        when(product.getProductDescription()).thenReturn("test");
        assertEquals(product.getProductDescription(), "test");
    }

    /**
     * Test of setProductDescription method, of class Product.
     */
    @Test
    public void testSetProductDescription() {
        System.out.println("setProductDescription");
        product.setProductDescription("test");
        assertEquals("test", product.getProductDescription());
    }

    /**
     * Test of getProductSchedule method, of class Product.
     */
    @Test
    public void testGetProductSchedule() {
        System.out.println("getProductSchedule");
        when(product.getProductSchedule()).thenReturn("test");
        assertEquals(product.getProductSchedule(), "test");
    }

    /**
     * Test of setProductSchedule method, of class Product.
     */
    @Test
    public void testSetProductSchedule() {
        System.out.println("setProductSchedule");
        product.setProductSchedule("test");
        assertEquals("test", product.getProductSchedule());
    }

    /**
     * Test of getDosageForm method, of class Product.
     */
    @Test
    public void testGetDosageForm() {
        System.out.println("getDosageForm");
        when(product.getDosageForm()).thenReturn("test");
        assertEquals(product.getDosageForm(), "test");

    }

    /**
     * Test of setDosageForm method, of class Product.
     */
    @Test
    public void testSetDosageForm() {
        System.out.println("setDosageForm");
        product.setDosageForm("test");
        assertEquals("test", product.getDosageForm());
    }

    /**
     * Test of getProductStrength method, of class Product.
     */
    @Test
    public void testGetProductStrength() {
        System.out.println("getProductStrength");
        when(product.getProductStrength()).thenReturn("test");
        assertEquals(product.getProductStrength(), "test");
    }

    /**
     * Test of setProductStrength method, of class Product.
     */
    @Test
    public void testSetProductStrength() {
        System.out.println("setProductStrength");
        product.setProductStrength("test");
        assertEquals("test", product.getProductStrength());
    }
    
}
