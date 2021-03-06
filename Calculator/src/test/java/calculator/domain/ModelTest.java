package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelTest {
    
    Model m;
    
    public ModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        m = new Model();
    }
    
    @After
    public void tearDown() {
    }    
    
    @Test
    public void keyGivesCorrectOperator() {
        assertEquals(new Addition().getClass(), m.getOperator("+").getClass());        
    }
    
    @Test
    public void unknownKeyGivesUnknowType() {
        assertEquals(new Unknown().getClass(), m.getOperator("idk").getClass());
    }
    
    @Test
    public void calculateReturnsCorrectResult() {
        assertEquals(7, m.calculateTwoNumbers(10, 3, "--"));
    }

}
