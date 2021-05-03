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
    public void keyGivesRightOperator() {
        assertEquals(new Sum().getClass(), m.get("+").getClass());        
    }
    
    @Test
    public void unknownKeyGivesUnknowType() {
        assertEquals(new Unknow().getClass(), m.get("idk").getClass());
    }

}
