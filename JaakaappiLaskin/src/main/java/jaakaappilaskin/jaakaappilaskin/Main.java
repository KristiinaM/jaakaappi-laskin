
package jaakaappilaskin.jaakaappilaskin;

public class Main {
    
    public static void main(String[] args){
        
    Ruoka kurpitsa = new Ruoka ("kurpitsa");
    Ruoka juusto = new Ruoka ("juusto");
    
    Jaakaappi jaakaappi = new Jaakaappi();
    
    jaakaappi.lisaaRuoka(kurpitsa);
    
    jaakaappi.lisaaRuoka(juusto);
    
    jaakaappi.tulosta();
    
    jaakaappi.poistaRuoka(juusto);
    
    jaakaappi.tulosta();
    
    String lista = jaakaappi.toString();
    
    System.out.println(lista);
    
    
    
    
    }
}
