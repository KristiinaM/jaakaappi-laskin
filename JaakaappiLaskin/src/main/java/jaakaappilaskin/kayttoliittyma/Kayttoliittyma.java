
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
 * Kayttoliittyma, jonka kautta jaakaappilaskimeen paasee kasiksi
 * se on jaoteltu sen mukaan, miten sen rivit muodostuvat.
 */

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Jaakaappi jaakaappi;
    private ReseptiLista reseptilista;
    
    public Kayttoliittyma (Jaakaappi jaakaappi, ReseptiLista reseptilista){
        this.jaakaappi = jaakaappi;
        this.reseptilista = reseptilista;
    } 
    
    @Override
    public void run() {
        frame =  new JFrame("Jaakaappilaskin");
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
    }
    
    /**
     * Luo komponentteja kayttoliittyman ikkunan sisalle. Komponenetit on 
     * jarjestetty ikkunassa esiintyvien rivien mukaisesti. 
     * 
     * @param container, purkki, jonka sisalle kaikki osat tulevat. 
     */
    
    
    private void luoKomponentit(Container container) {
       
        GridLayout layout = new GridLayout(7, 4);
        container.setLayout(layout);
        
  
        
        //1. rivi
        
        
        container.add(new JLabel ("Tämä on jääkaappilaskin!"));
        container.add(new JLabel(""));
        container.add(new JLabel (""));
        container.add(new JLabel (""));
        
        //2. rivi, ohjeita
        
        JTextArea ohje1 = new JTextArea("Lisää ruoan nimi alle");
        ohje1.setEditable(false);
        JTextArea ohje2 = new JTextArea ("Lisää säilyvyys alle \n (tyhjäksi jätettynä oletus 5 päivää)");
        ohje2.setEditable(false);
        JLabel tyhja = new JLabel("");
        
        container.add(ohje1);
        container.add(ohje2);
        container.add(tyhja);
        container.add(new JLabel(""));
                
        //2. rivi, lisaaja ja kaksi tekstikenttaa
        
        JTextField ruoanNimi = new JTextField("");
        JTextField ruoanSailyvyys = new JTextField();
        JButton lisaaKaappiin = new JButton ("Lisää jääkaappiin");
        RuokaLisaaja ruokaLisaaja = new RuokaLisaaja(this.jaakaappi,ruoanNimi,ruoanSailyvyys);
        JLabel ohje3 =  new JLabel("Valitse mitä haluat tehdä");
        
        lisaaKaappiin.addActionListener(ruokaLisaaja);
        
        container.add(ruoanNimi);
        container.add(ruoanSailyvyys);
        container.add(ohje3);
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
       //tehtavanvaihtorivi, 4. rivi
        
        container.add(new JLabel("Reseptin lisääminen ja"));
        container.add(new JLabel("poistaminen alla"));
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        
       //ohjerivi, 5. rivi
        JTextArea ohje4 = new JTextArea("Lisää reseptin nimi alle. \n(reseptin nimi ei saa olla \nlistalla valmiina)");
        ohje4.setEditable(false);
        JTextArea ohje5 = new JTextArea("Lisää ainesosat alle. \n (muotoilu: \n 'aineA 1 tl' \n 1 ainesosa/rivi) ");
        ohje5.setEditable(false);
        JTextArea ohje6 = new JTextArea("Reseptin poistamiseen \nriittää reseptin nimi");
        ohje6.setEditable(false);
        
        container.add(ohje4);
        container.add(ohje5);
        container.add(new JLabel(""));
        container.add(ohje6);
        
       //reseptinlisäys, 5. rivi
        
        JTextField reseptinNimi = new JTextField("");
        JTextArea reseptinAineet = new JTextArea("");
        JButton uusiResepti = new JButton("Lisää uusi resepti");
        ReseptiLisaaja reseptiLisaaja= new ReseptiLisaaja(reseptinNimi, reseptinAineet, this.reseptilista);
        uusiResepti.addActionListener(reseptiLisaaja);
        
        container.add(reseptinNimi);
        container.add(reseptinAineet);
        container.add(uusiResepti);
                
        //reseptin poistaminen
        
        JButton poistaResepti = new JButton("Poista Resepti");
        ReseptiPoistaja reseptiPoistaja = new ReseptiPoistaja(this.reseptilista, reseptinNimi);
        poistaResepti.addActionListener(reseptiPoistaja);
        
        container.add(poistaResepti);
        
    }
    
    public JFrame getFrame() {
        return frame;
    
    }
}
