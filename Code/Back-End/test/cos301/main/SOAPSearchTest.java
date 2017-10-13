/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cos301.main;

import cos301.datasource.Product;
import java.util.List;
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
public class SOAPSearchTest {
    
    SOAPSearch soapSearch = null;
    String productName = null;
    
    public SOAPSearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        soapSearch = new SOAPSearch();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class SOAPSearch.
     */
    @Test
    public void testSearch() {
        System.out.println("SOAP Search");
        productName = "Panado";
        List<Product> result = soapSearch.search(productName);
        
        assertEquals(27, result.size());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    /**
     * Test of search method, of class SOAPSearch.
     */
    @Test
    public void testNullValueSearch() {
        System.out.println("Null Value SOAP Search");
        productName = "";
        List<Product> result = soapSearch.search(productName);
        
        assertEquals(0, result.size());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
