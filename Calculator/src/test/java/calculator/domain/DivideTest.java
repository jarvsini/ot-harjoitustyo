
package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DivideTest {
    Divide d;
    
    public DivideTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       d = new Divide();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void givesCorrectResult() {
        double epsilon = 0.000001d;
        assertEquals(4.0, d.run(10.0, 2.5), epsilon);
    }
}
