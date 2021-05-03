package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SumTest {
    Sum s;
    
    public SumTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        s = new Sum();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void givesCorrectResult() {
        double epsilon = 0.000001d;
        assertEquals(6.0, s.run(2.0, 4.0), epsilon);
    }

}
