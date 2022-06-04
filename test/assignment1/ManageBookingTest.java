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
public class ManageBookingTest {
    
    public ManageBookingTest() {
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
     * Test of cancelBooking method, of class ManageBooking.
     *
    @Test
    public void testCancelBooking() {
        System.out.println("cancelBooking");
        ManageBooking instance = new ManageBooking();
        instance.cancelBooking();

    }*/

    /**
     * Test of validBooking method, of class ManageBooking.
     */
    @Test
    public void testValidBooking() {
        String ref = "last03-06-2022rm1";
        ManageBooking instance = new ManageBooking();
        boolean expResult = true;
        boolean result = instance.validBooking(ref);
        assertEquals(expResult, result);

    }

    
}
