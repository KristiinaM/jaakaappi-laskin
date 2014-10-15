
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.ReseptiLista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class ReseptiEtsijaAine implements ActionListener{

    private ReseptiLista reseptilista;
    private JTextField ruoanNimi;
    private IkkunaAvaaja ikkunaAvaaja;
    
    
    public ReseptiEtsijaAine(ReseptiLista reseptilista, JTextField ruoanNimi){
        this.reseptilista  = reseptilista;
        this.ruoanNimi = ruoanNimi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ruoka = this.ruoanNimi.getText();
        
        String tulos = reseptilista.reseptiAineelle(ruoka);
        this.ikkunaAvaaja = new IkkunaAvaaja(tulos);
        this.ikkunaAvaaja.run();
    }
    

    
}
