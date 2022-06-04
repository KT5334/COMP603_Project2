/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dorae
 */
public class GuestTest {
    
    public GuestTest() {
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
     * Test of createGuest method, of class Guest.
     */
    @Test
    public void testCreateGuest() {
        Guest guest = new Guest("first", "last", "test@test.com");
 
        HotelData expResult = new HotelData();
        expResult.emailFlag = false;
        HotelData result = guest.createGuest();
        assertEquals(expResult.emailFlag, result.emailFlag);

    }

    /**
     * Test of checkEmail method, of class Guest.
     */
    @Test
    public void testCheckEmail() {
        Guest guest = new Guest("first", "last", "test@test.com");
        boolean expResult = true;
        boolean result = guest.checkEmail();
        assertEquals(expResult, result);
        guest.db.closeConnections();

    }


}
