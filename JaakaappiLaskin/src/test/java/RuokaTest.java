

import jaakaappilaskin.jaakaappilaskin.Ruoka;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RuokaTest {
    
    public RuokaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void uusiRuoka(){
        Ruoka ruoka = new Ruoka("maito");
        assertEquals("maito", ruoka.getNimi());
    }
    
    @Test
    public void RuokaToSting(){
        Ruoka ruoka = new Ruoka ("maito");
        assertEquals(ruoka.getNimi(), ruoka.toString());
    }
}
