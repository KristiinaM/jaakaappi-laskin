
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * KÃ¤yttÃ¶liittymÃ¤, jonka kautta jÃ¤Ã¤kaappilaskimeen pÃ¤Ã¤see kÃ¤siksi
 * 
 */

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Jaakaappi jaakaappi;
    private ReseptiLista reseptilista;
    
    public Kayttoliittyma (Jaakaappi jaakaappi, ReseptiLista reseptiLista){
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
    
    /**
     * Luo komponentteja kÃ¤yttÃ¶liittymÃ¤n ikkunan sisÃ¤lle. Komponenetit on 
     * jÃ¤rjestetty ikkunassa esiintyvien rivien mukaisesti. 
     * 
     * @param container, purkki, jonka sisÃ¤lle kaikki osat tulevat. 
     */
    
    
    private void luoKomponentit(Container container) {
       
        GridLayout layout = new GridLayout(3, 4);
        container.setLayout(layout);
        
  
        
        //1. rivi
        container.add(new JLabel ("Tämä on jääkaappilaskin!"));
        container.add(new JLabel(""));
        container.add(new JLabel ("Mitä haluat tehdä?"));
        container.add(new JLabel (""));
        
        //2. rivi, lisaaja ja kaksi tekstikenttÃ¤Ã¤
        
        JTextField ruoanNimi = new JTextField("ruoan nimi");
        JTextField ruoanSailyvyys = new JTextField();
        JButton lisaaKaappiin = new JButton ("Lisää jääkaappiin");
        RuokaLisaaja ruokaLisaaja = new RuokaLisaaja(this.jaakaappi,ruoanNimi,ruoanSailyvyys);
        JTextArea ohjeistus =  new JTextArea ("Lisää ruoan nimi \n ja säilyvyys(oletus 5 päivää)");
        ohjeistus.setEditable(false);
        
        lisaaKaappiin.addActionListener(ruokaLisaaja);
        
        container.add(ruoanNimi);
        container.add(ruoanSailyvyys);
        container.add(ohjeistus);
        container.add(lisaaKaappiin);
        
        // 3. rivi,
        
        // poistaja
        JButton poistaKaapista = new JButton ("Poista jääkaapista");
        RuokaPoistaja ruokaPoistaja = new RuokaPoistaja(this.jaakaappi, ruoanNimi);
        poistaKaapista.addActionListener(ruokaPoistaja);
        
        container.add(poistaKaapista);
        
        // jaakaapin sisallon listaaja-nappi. 
        
        JButton sisallonListaus = new JButton ("Jaakaapin sisällön listaus");
        JaakaapinSisaltoListaaja sisaltoListaaja = new JaakaapinSisaltoListaaja(this.jaakaappi);
        sisallonListaus.addActionListener(sisaltoListaaja);
        
        container.add(sisallonListaus);
        
        //reseptihakunappi reseptin nimen perusteella
        
        JButton reseptiNimella = new JButton("Hae resepti sen nimellä");
        ReseptiEtsijaNimi reseptiEtsijaNimi = new ReseptiEtsijaNimi(this.reseptilista, ruoanNimi);
        reseptiNimella.addActionListener(reseptiEtsijaNimi);
        
        container.add(reseptiNimella);
        

        //reseptihakunappi reseprin aineen perusteella
        
        JButton reseptiAineelle = new JButton ("Hae resepti tietylle aineelle");
        ReseptiEtsijaAine reseptiEtsijaAine = new ReseptiEtsijaAine(this.reseptilista, ruoanNimi);
        reseptiAineelle.addActionListener(reseptiEtsijaAine);
        
        container.add(reseptiAineelle);
        
       // container.add(new JButton ("Uusi resepti"));
        
        
        
                
        
    }
    
    public JFrame getFrame() {
        return frame;
    
    }
}
