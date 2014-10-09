
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.ReseptiLista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class ReseptiEtsijaAine implements ActionListener{

    private ReseptiLista reseptilista;
    private String ruoanNimi;
    private IkkunaAvaaja ikkunaAvaaja;
    
    
    public ReseptiEtsijaAine(ReseptiLista Reseptilista, JTextField ruoanNimi){
        this.reseptilista  = reseptilista;
        this.ruoanNimi = ruoanNimi.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tulos = reseptilista.reseptiAineelle(ruoanNimi);
        this.ikkunaAvaaja = new IkkunaAvaaja(tulos);
        this.ikkunaAvaaja.run();
    }
    

    
}
