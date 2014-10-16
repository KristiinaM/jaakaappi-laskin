
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.Jaakaappi;
import jaakaappilaskin.sovelluslogiikka.Ruoka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * poistaa ruoan jäälaapista;
 * 
 */

public class RuokaPoistaja implements ActionListener {
    
    private Jaakaappi jaakaappi;
    private JTextField ruoanNimi;
    private IkkunaAvaaja ikkunaAvaaja;
    
    public RuokaPoistaja (Jaakaappi jaakaappi, JTextField ruoanNimi){
        this.jaakaappi = jaakaappi;
        this.ruoanNimi = ruoanNimi;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
        if (ruoanNimi.getText().equals("")){
            return;
        }
        else{
            Ruoka ruoka = new Ruoka (ruoanNimi.getText());
            boolean onnistuiko = jaakaappi.poistaRuoka(ruoka);
            if(onnistuiko != true){
                String eiLoydy = "Ruokaa ei löytynyt.";
                this.ikkunaAvaaja = new IkkunaAvaaja(eiLoydy);
                this.ikkunaAvaaja.run();
            }
        }
        
        ruoanNimi.setText("ruoan nimi");
        
    }
    
}
   
