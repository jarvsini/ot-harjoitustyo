package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnknownTest {
    Unknown u;
    
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
        u = new Unknown();
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void cantCalculate() {
         assertEquals(0, u.run(1,2));
     }
}
