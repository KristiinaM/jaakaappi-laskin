
package jaakaappilaskin.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VanhaksiMenneetListaaja implements ActionListener{

    private IkkunaAvaaja ikkunaAvaaja;
    
    public VanhaksiMenneetListaaja(){
        ikkunaAvaaja = new IkkunaAvaaja("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ikkunaAvaaja.run();
    }
    
}
    
  
