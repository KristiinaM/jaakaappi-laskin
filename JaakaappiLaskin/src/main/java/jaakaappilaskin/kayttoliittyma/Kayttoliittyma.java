
package jaakaappilaskin.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    
    @Override
    public void run() {
        frame =  new JFrame("Jaakaappilaskin");
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container) {
        JLabel alkuteksti = new JLabel ("Tämä on jääkaappilaskin! Se pitää kirjaa"
        +" jääkaappisi sisällöstä ja kertoo, mitä kaikkea tarvitset minkäkin "
        +"ruoan tekemiseen");
        container.add((alkuteksti), BorderLayout.NORTH);
        
        container.add(new JButton ("Uusia ostoksia"), BorderLayout.WEST);
        
        container.add(new JButton ("Vanhaksi menneet ruoat"), BorderLayout.EAST);
        
        container.add(new JButton ("Uusi resepti"), BorderLayout.CENTER);
        
        container.add(new JButton ("vanhat reseptit"), BorderLayout.SOUTH);
                
        
    }
    
    public JFrame getFrame() {
        return frame;
    
    }
}
