
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.ReseptiLista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ReseptiEtsijaNimi implements ActionListener{

    private IkkunaAvaaja ikkunaAvaaja;
    ReseptiLista reseptilista;
    String ruoanNimi;
    
    public ReseptiEtsijaNimi(ReseptiLista reseptilista, JTextField ruoanNimi){
        this.reseptilista = new ReseptiLista();
        this.ruoanNimi = ruoanNimi.getText();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String tulos = reseptilista.etsiResepti(ruoanNimi);
        this.ikkunaAvaaja = new IkkunaAvaaja(tulos);
        this.ikkunaAvaaja.run();
    }
    

}
