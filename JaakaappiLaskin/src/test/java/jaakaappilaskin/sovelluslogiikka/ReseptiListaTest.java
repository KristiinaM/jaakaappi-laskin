package jaakaappilaskin.sovelluslogiikka;


import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReseptiListaTest {
    
    ReseptiLista reseptilista;
    
    public ReseptiListaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        reseptilista = new ReseptiLista();
    }
    
    @After
    public void tearDown() {
    }

    
    private void lisaaResepteja(ReseptiLista reseptilista){
        ArrayList<Ainesosa> puuronAineet = new ArrayList <>();
        Ainesosa hiutale = new Ainesosa("hiutale", 2, "dl");
        Ainesosa vesi = new Ainesosa("vesi", 5, "dl");
        Ainesosa suola = new Ainesosa("suola", 1, "tl");
        
        puuronAineet.add(hiutale);
        puuronAineet.add(vesi);
        puuronAineet.add(suola);
        
        ArrayList<Ainesosa> pizzapohja = new ArrayList <>();
        Ainesosa jauhoja =  new Ainesosa ("jauhoja", 4, "dl");
        Ainesosa vesipizzaan = new Ainesosa ("vesi", 2.5, "dl");
        Ainesosa hiiva = new Ainesosa ("hiiva", 25, "g");
        Ainesosa oljy = new Ainesosa ("öljy", 0.5, "dl");
        
        pizzapohja.add(jauhoja);
        pizzapohja.add(vesipizzaan);
        pizzapohja.add(hiiva);
        pizzapohja.add(oljy);
        pizzapohja.add(suola);
        
        
        reseptilista.lisaaResepti("puuro", puuronAineet);
        reseptilista.lisaaResepti("pizzapohja", pizzapohja);
    }
    
    @Test
    public void reseptinHaku(){
        this.lisaaResepteja(reseptilista);
        
        assertEquals("puuro\nhiutale 2 dl\nvesi 5 dl\nsuola 1 tl\n", reseptilista.etsiResepti("puuro"));  
    }
    
    @Test
    public void reseptinHakuAineelle(){
        this.lisaaResepteja(reseptilista);
        
        assertEquals("puuro\nhiutale 2 dl\nvesi 5 dl\nsuola 1 tl\n\n",reseptilista.reseptiAineelle("hiutale"));
    
    }
    
    @Test
    public void reseptinHakuUseamminEsiintyvalleAineelle(){
        this.lisaaResepteja(reseptilista);
        
        assertEquals("puuro\nhiutale 2 dl\nvesi 5 dl\nsuola 1 tl\n\npizzapohja\njauhoja 4 dl\nvesi 2.5 dl\nhiiva 25 g\nöljy 0.5 dl\nsuola 1 tl\n\n", reseptilista.reseptiAineelle("suola"));
    }
    
    @Test
    public void reseptinHakuAineelleToinen(){
        this.lisaaResepteja(reseptilista);
        
        assertEquals("pizzapohja\njauhoja 4 dl\nvesi 2.5 dl\nhiiva 25 g\nöljy 0.5 dl\nsuola 1 tl\n\n" ,reseptilista.reseptiAineelle("jauhoja"));
    
    }
    
    @Test
    public void AinettaEiOle(){
        this.lisaaResepteja(reseptilista);
        assertEquals("Reseptiä ei löytynyt", reseptilista.reseptiAineelle("kurpitsa"));
    }
    
    @Test
    public void ReseptiaEiOle(){
        this.lisaaResepteja(reseptilista);
        assertEquals("Reseptiä ei löytynyt", reseptilista.etsiResepti("piirakka"));
    }
    
    @Test 
    public void tyhjaLista(){
        assertEquals("Reseptiä ei löytynyt", reseptilista.etsiResepti("piirakka"));
        assertEquals("Reseptiä ei löytynyt", reseptilista.reseptiAineelle("maito"));
    }
    
    @Test 
    public void uudenReseptinLisaaminen(){
        this.lisaaResepteja(reseptilista);
        ArrayList<Ainesosa> salaatti = new ArrayList <>();
        Ainesosa lehtisalaatti = new Ainesosa("lehtisalaatti", 1, "kerä");
        Ainesosa kurkku = new Ainesosa("kurkku", 1, "kpl");
        Ainesosa tomaatti = new Ainesosa("tomaatti", 4, "kpl");
        assertEquals(true, reseptilista.lisaaResepti("Salaatti", salaatti));
    }
    
    @Test
    public void samanNimisenReseptinLisaaminen(){
        this.lisaaResepteja(reseptilista);
        
        ArrayList<Ainesosa> pizzapohja = new ArrayList <>();
        Ainesosa jauhoja =  new Ainesosa ("jauhoja", 4, "dl");
        Ainesosa vesipizzaan = new Ainesosa ("vesi", 2.5, "dl");
        Ainesosa hiiva = new Ainesosa ("hiiva", 25, "g");
        Ainesosa oljy = new Ainesosa ("öljy", 0.5, "dl");
        
        assertEquals(false, reseptilista.lisaaResepti("pizzapohja", pizzapohja));
    }
    
    @Test
    public void loytyvanReseptinPoistaminen(){
        this.lisaaResepteja(reseptilista);
        assertEquals(true, reseptilista.poistaResepti("pizzapohja"));
        assertEquals("puuro\nhiutale 2 dl\nvesi 5 dl\nsuola 1 tl\n", reseptilista.etsiResepti("puuro"));
                
    }
    
    @Test
    public void eiLoytyvanReseptinPoistaminen(){
        this.lisaaResepteja(reseptilista);
        assertEquals(false, reseptilista.poistaResepti("olematon"));
    }
    
    @Test
    public void samatAineet(){
        
        this.lisaaResepteja(reseptilista);
        
        ArrayList<Ainesosa> piirasPohja = new ArrayList <>();
        Ainesosa jauhoja =  new Ainesosa ("jauhoja", 4, "dl");
        Ainesosa vesipizzaan = new Ainesosa ("vesi", 2.5, "dl");
        Ainesosa hiiva = new Ainesosa ("hiiva", 25, "g");
        Ainesosa oljy = new Ainesosa ("öljy", 0.5, "dl");
        piirasPohja.add(jauhoja);
        piirasPohja.add(vesipizzaan);
        piirasPohja.add(hiiva);
        piirasPohja.add(oljy);
        
        reseptilista.lisaaResepti("piiraspohja", piirasPohja);
        reseptilista.poistaResepti("pizzapohja");
       
        assertEquals("piiraspohja\njauhoja 4 dl\nvesi 2.5 dl\nhiiva 25 g\nöljy 0.5 dl\n", reseptilista.etsiResepti("piiraspohja"));
    }
    
} 



    


