
package jaakaappilaskin.jaakaappilaskin;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args){
        
    Ruoka kurpitsa = new Ruoka ("kurpitsa");
    Ruoka juusto = new Ruoka ("juusto");
    
    Jaakaappi jaakaappi = new Jaakaappi();
    
    jaakaappi.lisaaRuoka(kurpitsa);
    
    jaakaappi.lisaaRuoka(juusto);
    
    jaakaappi.tulosta();
    
    jaakaappi.jarjesta();
    
    jaakaappi.tulosta();
    
    jaakaappi.poistaRuoka(juusto);
    
    jaakaappi.tulosta();
    
    String lista = jaakaappi.toString();
    
    System.out.println(lista);
    
    
    ArrayList<Ainesosa> puuronAineet = new ArrayList <Ainesosa>();
    Ainesosa hiutale = new Ainesosa("hiutale", 2, "dl");
    Ainesosa vesi = new Ainesosa("vesi", 5, "dl");
    Ainesosa suola = new Ainesosa("suola", 1, "tl");
        
    puuronAineet.add(hiutale);
    puuronAineet.add(vesi);
    puuronAineet.add(suola);
        
    
    ReseptiLista reseptilista = new ReseptiLista();
    reseptilista.lisaaResepti("puuro", puuronAineet);
    
    String resepti = reseptilista.etsiResepti("puuro");
    
    System.out.println(resepti);
    
    resepti = "?";
    
    resepti = reseptilista.reseptiAineelle("hiutale");
    
    System.out.println(resepti);
        
    
    
    
    
    
    }
}
