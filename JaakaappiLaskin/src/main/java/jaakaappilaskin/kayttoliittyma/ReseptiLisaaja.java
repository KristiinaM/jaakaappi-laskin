
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Tämä luokka lisää reseptejä reseptilistaan
 * 
 */

public class ReseptiLisaaja implements ActionListener{
    
    private JTextField nimi;
    private JTextArea aineet;
    private IkkunaAvaaja ikkunaAvaaja;
    private ArrayList<Ainesosa> reseptinAineet;
    private ReseptiLista reseptiLista; 
    

    public ReseptiLisaaja(JTextField nimi, JTextArea aineet, ReseptiLista reseptilista){
         this.nimi = nimi;
         this.aineet = aineet;
         this.reseptiLista = reseptilista;
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //uusi lista, mihin listatas tämän reseptin aineet.
        
        this.reseptinAineet = new ArrayList<>();
       
        //haettavan reseptin nimi;
        
        String reseptinNimi = this.nimi.getText();
        
        //hajotetaan syöte riveittäin erillisiksi String-muuttujiksi
        
        String rivit[] = aineet.getText().split ("\n");
       
        // ArrayList tyyppinen lista riveistä
        
        ArrayList<String> listaAineenKomponenteista = new ArrayList<>(9);
        
        // käydään läpi ArrayList jossa listattuna syötteen rivit ja jaetaan esillisiksi sanoiksi.
        // lisätään kaikki osat erillisiksi String muuttujiksi listaan
        
        for (String rivi : rivit){
            String sanat[] = rivi.split(" ");
            listaAineenKomponenteista.addAll(Arrays.asList(sanat));
        }
       
        // Taskistetaan, että komponentteja on oikea määrä, että saadaan ainesOsia muodostettua.
        
        if(listaAineenKomponenteista.size()%3 != 0){
            ikkunaAvaaja = new IkkunaAvaaja ("\nAntamassasi reseptissä on virhe. \n Tarkistathan, että kaikki välit ovat paikoillaan \n ja kaikille aineille on määritelty oikeat määrät.\n");
            ikkunaAvaaja.run();
            return;
        }
        
        // tehdään uudet ainesosat listan komponenteista ja lisätään ne reseption aineisiin
        
        int i = 0;
        
        while (i < listaAineenKomponenteista.size()-2){
            String aine = listaAineenKomponenteista.get(i);
            i ++;
            double maara;  // käyttöliittymässä käytössä ainoastaan double-arvot yhdistelmän tuottaneiden ongelmien vuoksi
             
                try{
                    maara = Double.parseDouble(listaAineenKomponenteista.get(i));
                }
                catch(Exception ex){
                
                this.ikkunaAvaaja  = new IkkunaAvaaja (" Jokin syöttämäsi määrä ei ole numero. ");
                this.ikkunaAvaaja.run();
                return;
                }
            
            i ++;
            
            String maaranMitta = listaAineenKomponenteista.get(i);
            i ++;
        
                reseptinAineet.add(new Ainesosa(aine, maara, maaranMitta));
            
        }
        
        
        // tarkistetaan lisättiinkö uusi resepti
        
        boolean tapahtuiko = this.reseptiLista.lisaaResepti(reseptinNimi, reseptinAineet);
        
        if (tapahtuiko == false){ 
            this.ikkunaAvaaja = new IkkunaAvaaja (" Saman niminen resepti on jo olemassa \n nimeä resepti uudestaan. ");
            ikkunaAvaaja.run();
            return;
        }
        
        this.ikkunaAvaaja = new IkkunaAvaaja(" Lisätty resepti näyttää tältä. \n Tarkistathan, että kaikki on oikein \n\n\n" + this.reseptiLista.etsiResepti(reseptinNimi));
        this.ikkunaAvaaja.run();
     
        
        
    }
   
    
    
    
    
    
}

