package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinusTest {
    Minus m;
    
    public MinusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        m = new Minus();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void givesCorrectResult() {
        double epsilon = 0.000001d;
        assertEquals(16.0, m.run(31.0, 15.0), epsilon);
    }
}
