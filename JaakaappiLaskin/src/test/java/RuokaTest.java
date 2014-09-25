

import jaakaappilaskin.sovelluslogiikka.Ruoka;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RuokaTest {
    
    Ruoka ruoka;
    
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
        this.ruoka = new Ruoka("maito", 4);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void uusiRuoka(){
        assertEquals("maito", ruoka.getNimi());
    }
    
    @Test
    public void RuokaToSting(){
        assertEquals(ruoka.getNimi(), ruoka.toString());
    }
    
    @Test 
    public void ruokaaSailytetaan(){
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        assertEquals(2, ruoka.getSailyvyys());
    }
    
    @Test
    public void sailyvyysNolla(){
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        assertEquals (0, ruoka.getSailyvyys());
    }
    
    @Test
    public void sailyvyysNegatiivinen(){
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        ruoka.paivaVaihtuu();
        assertEquals(-2, ruoka.getSailyvyys());
    }
    
    @Test
    public void ruoanVertailtavuusAakkosissaEnnen(){
        assertEquals (2, ruoka.compareTo(new Ruoka ("ketsuppi")));
    }
    
    public void ruoanVertailuAakkosissaJalkeen(){
        assertEquals (-8, ruoka.compareTo(new Ruoka ("sima")));
    }
    
}
