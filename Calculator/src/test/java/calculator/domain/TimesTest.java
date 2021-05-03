package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimesTest {
    Times t;
    
    public TimesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        t = new Times();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void givesCorrectResult() {
        double epsilon = 0.000001d;
        assertEquals(6.0, t.run(2.0, 3.0), epsilon);
    }

}
