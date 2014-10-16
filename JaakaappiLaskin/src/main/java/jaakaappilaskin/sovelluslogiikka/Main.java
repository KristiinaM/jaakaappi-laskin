
package jaakaappilaskin.sovelluslogiikka;

import jaakaappilaskin.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args){
    
        Jaakaappi jaakaappi = new Jaakaappi();
        ReseptiLista reseptiLista = new ReseptiLista();
        

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(jaakaappi, reseptiLista);
        SwingUtilities.invokeLater(kayttoliittyma);


        
    }   
    
        
    

}
    
    
    
    

