
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class RuokaLisaaja implements ActionListener {
    
    private Jaakaappi jaakaappi;
    private JTextField ruoanNimi;
    private JTextField ruoanSailyvyys;
    private IkkunaAvaaja ikkunaAvaaja;
    
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
        
        if (ruoanNimi.getText().equals("")){
            return;
        }
        
        Ruoka ruoka= new Ruoka("");
        
        if (ruoanSailyvyys.getText().isEmpty()){
            ruoka = new Ruoka(ruoanNimi.getText());
        }
        else {
            int sailyvyys;
            
            try{
               sailyvyys = Integer.parseInt(ruoanSailyvyys.getText());
            } 
            catch (NumberFormatException ex){
                this.ikkunaAvaaja =  new IkkunaAvaaja (" Säilyvyyden tulee olla numero. ");
                this.ikkunaAvaaja.run();
                return;
            }
            
            if(sailyvyys >= 1){
                ruoka = new Ruoka (ruoanNimi.getText(), sailyvyys);
            }
            else{
                this.ikkunaAvaaja = new IkkunaAvaaja(" Säilyvyys on liian pieni. ");
                this.ikkunaAvaaja.run();
            }
        }
        
        this.jaakaappi.lisaaRuoka(ruoka);
        ruoanNimi.setText("ruoan nimi");
        ruoanSailyvyys.setText(null);
            
        }
    
}
