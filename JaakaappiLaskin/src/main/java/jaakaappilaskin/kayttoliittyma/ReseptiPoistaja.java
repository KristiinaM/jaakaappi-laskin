
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.ReseptiLista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Poistaa reseptin listasta.
 * 
 */
public class ReseptiPoistaja implements ActionListener{

    private ReseptiLista reseptilista;
    private JTextField poistettavanNimi;
    private IkkunaAvaaja ikkunaAvaaja;
    
    
    public ReseptiPoistaja (ReseptiLista reseptilista, JTextField poistettavanNimi){
        this.reseptilista = reseptilista;
        this.poistettavanNimi = poistettavanNimi;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String poistettava = this.poistettavanNimi.getText();
        this.reseptilista.poistaResepti(poistettava);
        
        this.ikkunaAvaaja  = new IkkunaAvaaja(" Resepti '" + poistettava + "' on poistettu");
        this.ikkunaAvaaja.run();
        
        
    }
    
    
    
}
