
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


    @Test
    public void reseptinEtsiminen(){
        
        ReseptiLista reseptit =  new ReseptiLista();
        
        ArrayList<Ruoka> puuro = new ArrayList<Ruoka>();
        Ruoka hiutale = new Ruoka("hiutale");
        Ruoka vesi =  new Ruoka ("vesi");
        Ruoka suola = new Ruoka ("suola");
        puuro.add(hiutale);
        puuro.add(suola);
        puuro.add(vesi);
        reseptit.lisaaResepti("puuro", puuro);
        
        String aineet = "";
        for (Ruoka ruoka : reseptit.etsiResepti("puuro")){
            aineet = aineet + ruoka.getNimi() + ", ";
            }
        assertEquals ("hiutale, suola, vesi, ", aineet);
         
    }
    

    } 


    


