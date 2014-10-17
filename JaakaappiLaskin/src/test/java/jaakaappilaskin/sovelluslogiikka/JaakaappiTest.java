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
    Jaakaappi kaappi;
    
    
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
        kaappi = new Jaakaappi();
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
        this.lisaaYksi(kaappi);
        assertEquals ("piima ", kaappi.toString());
        
    }
    
    @Test
    public void lisaaKaappiinEnemman(){
        this.lisaaKaksi(kaappi);
        assertEquals ("maito piima ", kaappi.toString());
    }
    
    @Test
    public void kaksiKaappia(){
        Jaakaappi kaappi2 = new Jaakaappi();
        this.lisaaKaksi(kaappi);
        this.lisaaYksi(kaappi2);
        assertEquals ("piima ", kaappi2.toString());
        assertEquals ("maito piima ", kaappi.toString());
                
    }
    
    @Test
    public void lisaaSama(){
        this.lisaaKaksi(kaappi);
        this.lisaaKaksi(kaappi);
        assertEquals("maito piima maito piima ", kaappi.toString());
    }
    
    @Test
    public void poista(){
        Ruoka maito = new Ruoka("maito");
        Ruoka piima = new Ruoka ("piima");
        kaappi.lisaaRuoka(maito);
        kaappi.lisaaRuoka(piima);
        kaappi.poistaRuoka(maito);
        assertEquals("piima ", kaappi.toString());
    }
    
    @Test
    public void poistaYksiMonesta(){
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
        this.lisaaKaksi(kaappi);
        this.lisaaKaksi(kaappi);
        kaappi.jarjesta();
        assertEquals ("maito maito piima piima ", kaappi.toString());
    }
    
    @Test
    public void tulostaa(){
        
        this.lisaaYksi(kaappi);
        this.lisaaKaksi(kaappi);
        
        kaappi.tulosta();
        assertEquals ( "maito säilyy 5 päivää\r\npiima säilyy 5 päivää\r\npiima säilyy 5 päivää\r\n",outContent.toString());
    }
    
    @Test 
    public void poistaPilaantuvin(){
        
        this.lisaaKaksi(kaappi);
        Ruoka maito = new Ruoka ("Maito", 6);
        kaappi.lisaaRuoka(maito);
        
        boolean onnistuiko = kaappi.poistaRuoka(maito);
        assertEquals(6, maito.getSailyvyys());
        assertEquals(true, onnistuiko);
        
    }
    
    @Test
    public void alaPosta(){
        Ruoka lasagne = new Ruoka("Lasagne");
        this.lisaaKaksi(kaappi);
        boolean tapahtuiko = kaappi.poistaRuoka(lasagne);
        
        assertEquals("Ruokaa ei löytynyt", outContent.toString());
        assertEquals(false, tapahtuiko);
    }
    
    @Test
    public void tyyhjennaKaappi(){
        this.lisaaYksi(kaappi);
        Ruoka piima = new Ruoka ("piima");
        kaappi.poistaRuoka(piima);
        assertEquals("", kaappi.toString());
    }
    
    @Test
    public void poistaakoOikein(){
        Ruoka piima = new Ruoka("Piima");
        this.lisaaYksi(kaappi);
        this.kaappi.poistaRuoka(piima);
        assertEquals("", kaappi.toString());
    }
  

        
    
}
