
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class RuokaLisaaja implements ActionListener {
    
    private Jaakaappi jaakaappi;
    private JTextField ruoanNimi;
    private JTextField ruoanSailyvyys;
    
    public RuokaLisaaja (Jaakaappi jaakaappi, JTextField ruoanNimi){
        this.jaakaappi = jaakaappi;
        this.ruoanNimi = ruoanNimi;
    }
    
    public RuokaLisaaja (Jaakaappi jaakaappi, JTextField ruoanNimi, JTextField ruoanSailyvyys){
        this.jaakaappi = jaakaappi;
        this.ruoanNimi = ruoanNimi;
        this.ruoanSailyvyys = ruoanSailyvyys;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (ruoanNimi.getText().equals("ruoan nimi")){
            return;
        }
        
        Ruoka ruoka;
        
        if (ruoanSailyvyys.getText().isEmpty()){
            ruoka = new Ruoka(ruoanNimi.getText());
        }
        else {
            int sailyvyys =Integer.parseInt(ruoanSailyvyys.getText());
            ruoka = new Ruoka (ruoanNimi.getText(), sailyvyys);
        }
        
        this.jaakaappi.lisaaRuoka(ruoka);
        ruoanNimi.setText("ruoan nimi");
        ruoanSailyvyys.setText(null);
            
        }
    
}
