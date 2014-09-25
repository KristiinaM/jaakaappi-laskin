
import jaakaappilaskin.sovelluslogiikka.Ainesosa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AinesosaTest {
    
    Ainesosa aine;
    
    public AinesosaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        aine = new Ainesosa("maito", 5, "dl");
    }
    
    @After
    public void tearDown() {
    }
    
    @ Test
    public void palauttaaNimen(){
        assertEquals ("maito", aine.getNimi());
    }
    
    @ Test 
    public void palauttaaMaaran(){
        assertEquals ("5 dl", aine.getMaara());
    }
    
    
    @ Test
    public void palauttaaTekstina(){
        assertEquals ("maito 5 dl", aine.toString());
    }
    
   @ Test
   public void palauttaaDoublenOikein(){
       this.aine = new Ainesosa("voi", 0.3, "kg");
       assertEquals ("voi 0.3 kg", aine.toString());
   }
            
            

  
}
