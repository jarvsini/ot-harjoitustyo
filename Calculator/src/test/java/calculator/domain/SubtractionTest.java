package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SubtractionTest {
    Subtraction m;
    
    public SubtractionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        m = new Subtraction();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void givesCorrectResult() {
        assertEquals(2, m.run(6, 4));
    }
}
