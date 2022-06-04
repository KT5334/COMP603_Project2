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
public class DateValidatorTest {
    
    public DateValidatorTest() {
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
     * Test of isValid method, of class DateValidator.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        String input = "06-03-2024";
        DateValidator instance = new DateValidator();
        boolean expResult = true;
        boolean result = instance.isValid(input);
        assertEquals(expResult, result);

    }
    
}
