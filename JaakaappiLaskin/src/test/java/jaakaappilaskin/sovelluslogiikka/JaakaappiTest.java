package jaakaappilaskin.sovelluslogiikka;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JaakaappiTest {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    
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
        System.setOut(new PrintStream(outContent));
    }
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
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
    
    @Test
    public void tulostaa(){
        Jaakaappi kaappi = new Jaakaappi();
        
        this.lisaaYksi(kaappi);
        this.lisaaKaksi(kaappi);
        
        kaappi.tulosta();
        assertEquals ( "maito säilyy 5 päivää\npiimä säilyy 5 päivää\npiimä säilyy 5 päivää",outContent.toString());
    }
    
    @Test 
    public void poistaPilaantuvin(){
        Jaakaappi kaappi = new Jaakaappi();
        
        this.lisaaKaksi(kaappi);
        Ruoka maito = new Ruoka ("Maito", 6);
        kaappi.lisaaRuoka(maito);
        
        kaappi.poistaRuoka(maito);
        assertEquals(6, maito.getSailyvyys());
        
    }
    
    @Test
    public void alaPosta(){
        Jaakaappi kaappi = new Jaakaappi();
        Ruoka lasagne = new Ruoka("Lasagne");
        this.lisaaKaksi(kaappi);
        kaappi.poistaRuoka(lasagne);
        
        assertEquals("Ruokaa ei löytynyt", outContent.toString());
    }

        
    
}
