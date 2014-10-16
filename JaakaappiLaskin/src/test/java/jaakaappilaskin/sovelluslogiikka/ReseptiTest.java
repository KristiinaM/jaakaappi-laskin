package jaakaappilaskin.sovelluslogiikka;


import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReseptiTest {
    
    public ReseptiTest() {
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
    public void ainesosanLisaaminen(){
        ArrayList<Ainesosa> ainesosat = new ArrayList<>(); 
        Resepti resepti = new Resepti("resepti", ainesosat);
        Ainesosa aine = new Ainesosa("aine", 5, "mittaa");
        resepti.lisaaAinesosa(aine);
        assertEquals("[aine 5 mittaa]" , resepti.haeAineet().toString());
    }


}
