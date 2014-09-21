
import jaakaappilaskin.jaakaappilaskin.Ainesosa;
import jaakaappilaskin.jaakaappilaskin.ReseptiLista;
import jaakaappilaskin.jaakaappilaskin.Ruoka;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReseptiListaTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    
    private void lisaaResepteja(ReseptiLista reseptilista){
        ArrayList<Ainesosa> puuronAineet = new ArrayList <Ainesosa>();
        Ainesosa hiutale = new Ainesosa("hiutale", 2, "dl");
        Ainesosa vesi = new Ainesosa("vesi", 5, "dl");
        Ainesosa suola = new Ainesosa("suola", 1, "tl");
        
        puuronAineet.add(hiutale);
        puuronAineet.add(vesi);
        puuronAineet.add(suola);
        
        
        reseptilista.lisaaResepti("puuro", puuronAineet);
        
    }
    
    @Test
    public void reseptinHaku(){
        
        ReseptiLista reseptilista = new ReseptiLista();
        
        this.lisaaResepteja(reseptilista);
        
        assertEquals("puuro\nhiutale 2 dl\nvesi 5 dl\nsuola 1 tl\n", reseptilista.etsiResepti("puuro"));
        
        
        

         
    }
    

    } 


    


