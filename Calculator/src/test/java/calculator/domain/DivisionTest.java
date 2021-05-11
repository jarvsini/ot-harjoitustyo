
package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DivisionTest {
    Division d;
    
    public DivisionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       d = new Division();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void givesCorrectResultWhenNoRemainder() {
        assertEquals(5, d.run(10,2));
    }
}
