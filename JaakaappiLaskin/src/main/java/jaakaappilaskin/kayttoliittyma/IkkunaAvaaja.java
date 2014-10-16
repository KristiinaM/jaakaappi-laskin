
package jaakaappilaskin.kayttoliittyma;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
* Tämä luokka avaa uuden ikkunan aina kun sellainen tarvitaan. 
*/

public class IkkunaAvaaja implements Runnable{
   
    
    private JFrame frame;
    private String tulostettava;
    
    
    public IkkunaAvaaja(String tulostettava){
        this.tulostettava = tulostettava;
    }
    
    @Override
    public void run() {
        frame = new JFrame();
        
        frame.setMinimumSize(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);   
    }
    
    
    
    private void luoKomponentit(Container container) {
        JTextArea vastaus =  new JTextArea(tulostettava);
        vastaus.setEditable(false);
        container.add(vastaus);
        
        
    }
        
        
}
