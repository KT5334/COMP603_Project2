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
public class BookingTest {
    
    public BookingTest() {
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
     * Test of createBooking method, of class Booking.
     */
    @Test
    public void testCreateBooking() {
        System.out.println("createBooking");
        Guest guest = new Guest("first", "last", "test@test.com");
        Booking instance = new Booking("03-06-2022", 1, guest);
        HotelData expResult = new HotelData();
        expResult.ref = "last03-06-2022rm1";
        HotelData result = instance.createBooking();
        assertEquals(expResult.ref, result.ref);

    }
    
}
