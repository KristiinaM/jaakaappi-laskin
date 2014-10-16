
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Tämä luokka kertoo mitä jääkaapissa on.
 * 
 */
public class JaakaapinSisaltoListaaja implements ActionListener{

    private IkkunaAvaaja ikkunaAvaaja;
    private Jaakaappi jaakaapppi;
    
    public JaakaapinSisaltoListaaja(Jaakaappi jaakaappi){
        this.jaakaapppi = jaakaappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String tulostus = this.jaakaapppi.tulostaStringiksi();
        this.ikkunaAvaaja = new IkkunaAvaaja(tulostus);
        ikkunaAvaaja.run();
    }
    
}
