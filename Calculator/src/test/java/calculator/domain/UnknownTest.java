/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jarvsini
 */
public class UnknownTest {
    Unknow u;
    
    public UnknownTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        u = new Unknow();
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void cantCalculate() {
        double epsilon = 0.000001d;
        assertEquals(0.0, u.run(1.0, 45.5), epsilon);
     }
}
