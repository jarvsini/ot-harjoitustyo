package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplicationTest {
    Multiplication t;
    
    public MultiplicationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        t = new Multiplication();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void givesCorrectResult() {
        assertEquals(6, t.run(2, 3));
    }

}
