
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Jaakaappi jaakaappi;
    
    public Kayttoliittyma (Jaakaappi jaakaappi){
        this.jaakaappi = jaakaappi;
    } 
    
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
       
        GridLayout layout = new GridLayout(3, 4);
        container.setLayout(layout);
        
  
        
        //1. rivi
        container.add(new JLabel ("Tämä on jääkaappilaskin!"));
        container.add(new JLabel(""));
        container.add(new JLabel ("Mitä haluat tehdä?"));
        container.add(new JLabel (""));
        
        //2. rivi
        
        JTextField ruoanNimi = new JTextField("ruoan nimi");
        JTextField ruoanSailyvyys = new JTextField();
        JButton lisaaKaappiin = new JButton ("Lisää jääkaappiin");
        RuokaLisaaja ruokaLisaaja = new RuokaLisaaja(this.jaakaappi,ruoanNimi,ruoanSailyvyys);
        lisaaKaappiin.addActionListener(ruokaLisaaja);
        
        container.add(ruoanNimi);
        container.add(ruoanSailyvyys);
        container.add(new JLabel ("Lisää ruoan nimi ja säilyvyys(oletus 5 päivää)"));
        container.add(lisaaKaappiin);
        
        
        container.add(new JButton ("Jaakaapin sisällön listaus"));
        container.add(new JButton ("Uusi resepti"));
        container.add(new JButton ("Reseptihaku"));
                
        
    }
    
    public JFrame getFrame() {
        return frame;
    
    }
}
