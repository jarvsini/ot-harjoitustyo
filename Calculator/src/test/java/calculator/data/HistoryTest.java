package calculator.data;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HistoryTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    
    History h;
    
    public HistoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        h = new History();
        h.setFile("testFile.txt");
    }
    
    @After
    public void tearDown() {
        File myTestObj = new File("testFile.txt"); 
        myTestObj.delete();
    }
    
    @Test
    public void writeHistoryChangesFile() {
        h.writeHistory("hello");
        System.setOut(new PrintStream(outputStreamCaptor));
        h.readHistory();
        Assert.assertEquals(";hello", outputStreamCaptor.toString()
      .trim());
    }
    
    @Test
    public void readingFileNoExistGivesError() {
        System.setOut(new PrintStream(outputStreamCaptor));
        h.readHistory();
        Assert.assertEquals("Tiedoston lukeminen epäonnistui.", outputStreamCaptor.toString()
      .trim());
    }

}
