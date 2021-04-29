package calculator.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ModelTest {
    
    Model testmodel;
    
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
        testmodel = new Model();
    }
    
    @After
    public void tearDown() {
    }
    
    
    //@Test
    //public void calculateGivesRigtResult() {
    //    assertEquals(2, testmodel.calculate(1, 1, "+") );
    //    assertEquals(1, testmodel.calculate(3, 2, "-") );
    //    assertEquals(20, testmodel.calculate(10, 2, "x") );
    //    assertEquals(10, testmodel.calculate(50, 5, "/") );
    //}

}
