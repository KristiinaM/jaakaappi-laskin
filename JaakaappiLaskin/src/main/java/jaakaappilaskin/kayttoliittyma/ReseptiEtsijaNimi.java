
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.ReseptiLista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
/**
 * Tämä luokka etsii tietyn nimistä reseptiä
 * 
 */
public class ReseptiEtsijaNimi implements ActionListener{

    private IkkunaAvaaja ikkunaAvaaja;
    ReseptiLista reseptilista;
    JTextField ruoanNimi;
    
    public ReseptiEtsijaNimi(ReseptiLista reseptilista, JTextField ruoanNimi){
        this.reseptilista = reseptilista;
        this.ruoanNimi = ruoanNimi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String ruoka = this.ruoanNimi.getText();
        
        String tulos = this.reseptilista.etsiResepti(ruoka);
        this.ikkunaAvaaja = new IkkunaAvaaja(tulos);
        this.ikkunaAvaaja.run();
    }
    

}
