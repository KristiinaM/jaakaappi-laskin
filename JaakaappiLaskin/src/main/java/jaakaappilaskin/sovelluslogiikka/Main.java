
package jaakaappilaskin.sovelluslogiikka;

import jaakaappilaskin.kayttoliittyma.Kayttoliittyma;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args){
    
    Jaakaappi jaakaappi = new Jaakaappi();
   
    Kayttoliittyma kayttoliittyma = new Kayttoliittyma(jaakaappi);
        SwingUtilities.invokeLater(kayttoliittyma);

    }
    
    
    
    
}
