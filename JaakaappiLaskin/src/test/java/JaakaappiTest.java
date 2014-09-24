

import jaakaappilaskin.sovelluslogiikka.Jaakaappi;
import jaakaappilaskin.sovelluslogiikka.Ruoka;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JaakaappiTest {
    
    public JaakaappiTest() {
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

    private void lisaaYksi(Jaakaappi kaappi){
        Ruoka piima = new Ruoka ("piima");
        kaappi.lisaaRuoka(piima);
    }
    
    private void lisaaKaksi(Jaakaappi kaappi){
        Ruoka maito = new Ruoka("maito");
        Ruoka piima = new Ruoka ("piima");
        kaappi.lisaaRuoka(maito);
        kaappi.lisaaRuoka(piima);
    }
    
    
    @Test
    public void lisaaKaappiin(){
        Jaakaappi kaappi = new Jaakaappi();
        this.lisaaYksi(kaappi);
        assertEquals ("piima ", kaappi.toString());
        
    }
    
    @Test
    public void lisaaKaappiinEnemman(){
        Jaakaappi kaappi = new Jaakaappi();
        this.lisaaKaksi(kaappi);
        assertEquals ("maito piima ", kaappi.toString());
    }
    
    @Test
    public void kaksiKaappia(){
        Jaakaappi kaappi1 = new Jaakaappi();
        Jaakaappi kaappi2 = new Jaakaappi();
        this.lisaaKaksi(kaappi1);
        this.lisaaYksi(kaappi2);
        assertEquals ("piima ", kaappi2.toString());
        assertEquals ("maito piima ", kaappi1.toString());
                
    }
    
    @Test
    public void lisaaSama(){
        Jaakaappi kaappi = new Jaakaappi();
        this.lisaaKaksi(kaappi);
        this.lisaaKaksi(kaappi);
        assertEquals("maito piima maito piima ", kaappi.toString());
    }
    
    @Test
    public void poista(){
        Jaakaappi kaappi = new Jaakaappi();
        Ruoka maito = new Ruoka("maito");
        Ruoka piima = new Ruoka ("piima");
        kaappi.lisaaRuoka(maito);
        kaappi.lisaaRuoka(piima);
        kaappi.poistaRuoka(maito);
        assertEquals("piima ", kaappi.toString());
    }
    
    @Test
    public void poistaYksiMonesta(){
        Jaakaappi kaappi = new Jaakaappi();
        Ruoka maito = new Ruoka("maito");
        Ruoka piima = new Ruoka ("piima");
        kaappi.lisaaRuoka(maito);
        kaappi.lisaaRuoka(piima);
        kaappi.lisaaRuoka(piima);
        kaappi.poistaRuoka(piima);
        assertEquals("maito piima ", kaappi.toString());
    }
    
    @Test
    public void jarjestaa(){
        Jaakaappi kaappi = new Jaakaappi();
        this.lisaaKaksi(kaappi);
        this.lisaaKaksi(kaappi);
        kaappi.jarjesta();
        assertEquals ("maito maito piima piima ", kaappi.toString());
    }

        
    
}
