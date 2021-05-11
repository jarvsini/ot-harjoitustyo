package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdditionTest {
    Addition s;
    
    public AdditionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        s = new Addition();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void givesCorrectResult() {
        assertEquals(6, s.run(2, 4));
    }

}
