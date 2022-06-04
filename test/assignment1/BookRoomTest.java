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
public class BookRoomTest {

    public BookRoomTest() {
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
     * Test of checkRoomAvailability method, of class BookRoom.
     */
    @Test
    public void testCheckRoomAvailability() {

        BookRoom instance = new BookRoom("03-06-2022");
        HotelData result = instance.checkRoomAvailability();

        HotelData expResult = new HotelData();
        for(int i = 1; i<11; i++){
            expResult.avRoom.add(i);
            
        }
        assertEquals(expResult.avRoom, result.avRoom);
        

    }

}
