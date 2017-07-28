/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cos301.datasource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class StockItemTest {
    
    public StockItemTest() {
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
     * Test of initialize method, of class StockItem.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        StockItem instance = new StockItem();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdStockItem method, of class StockItem.
     */
    @Test
    public void testGetIdStockItem() {
        System.out.println("getIdStockItem");
        StockItem instance = new StockItem();
        int expResult = 0;
        int result = instance.getIdStockItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdStockItem method, of class StockItem.
     */
    @Test
    public void testSetIdStockItem_int() {
        System.out.println("setIdStockItem");
        int idStockItem = 0;
        StockItem instance = new StockItem();
        instance.setIdStockItem(idStockItem);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdStockItem method, of class StockItem.
     */
    @Test
    public void testSetIdStockItem_String() {
        System.out.println("setIdStockItem");
        String idStockItem = "";
        StockItem instance = new StockItem();
        instance.setIdStockItem(idStockItem);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdProduct method, of class StockItem.
     */
    @Test
    public void testGetIdProduct() {
        System.out.println("getIdProduct");
        StockItem instance = new StockItem();
        int expResult = 0;
        int result = instance.getIdProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdProduct method, of class StockItem.
     */
    @Test
    public void testSetIdProduct_int() {
        System.out.println("setIdProduct");
        int idProduct = 0;
        StockItem instance = new StockItem();
        instance.setIdProduct(idProduct);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdProduct method, of class StockItem.
     */
    @Test
    public void testSetIdProduct_String() {
        System.out.println("setIdProduct");
        String idProduct = "";
        StockItem instance = new StockItem();
        instance.setIdProduct(idProduct);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdSupplier method, of class StockItem.
     */
    @Test
    public void testGetIdSupplier() {
        System.out.println("getIdSupplier");
        StockItem instance = new StockItem();
        int expResult = 0;
        int result = instance.getIdSupplier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdSupplier method, of class StockItem.
     */
    @Test
    public void testSetIdSupplier_int() {
        System.out.println("setIdSupplier");
        int idSupplier = 0;
        StockItem instance = new StockItem();
        instance.setIdSupplier(idSupplier);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdSupplier method, of class StockItem.
     */
    @Test
    public void testSetIdSupplier_String() {
        System.out.println("setIdSupplier");
        String idSupplier = "";
        StockItem instance = new StockItem();
        instance.setIdSupplier(idSupplier);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStockItemProdNo method, of class StockItem.
     */
    @Test
    public void testGetStockItemProdNo() {
        System.out.println("getStockItemProdNo");
        StockItem instance = new StockItem();
        String expResult = "";
        String result = instance.getStockItemProdNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStockItemProdNo method, of class StockItem.
     */
    @Test
    public void testSetStockItemProdNo() {
        System.out.println("setStockItemProdNo");
        String stockItemProdNo = "";
        StockItem instance = new StockItem();
        instance.setStockItemProdNo(stockItemProdNo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStockItemName method, of class StockItem.
     */
    @Test
    public void testGetStockItemName() {
        System.out.println("getStockItemName");
        StockItem instance = new StockItem();
        String expResult = "";
        String result = instance.getStockItemName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStockItemName method, of class StockItem.
     */
    @Test
    public void testSetStockItemName() {
        System.out.println("setStockItemName");
        String stockItemName = "";
        StockItem instance = new StockItem();
        instance.setStockItemName(stockItemName);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
