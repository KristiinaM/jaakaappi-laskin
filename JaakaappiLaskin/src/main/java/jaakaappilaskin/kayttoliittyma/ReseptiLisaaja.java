
package jaakaappilaskin.kayttoliittyma;

import jaakaappilaskin.sovelluslogiikka.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReseptiLisaaja implements ActionListener{
    
    private JTextField nimi;
    private JTextArea aineet;
    private IkkunaAvaaja ikkunaAvaaja;
    private ArrayList<Ainesosa> reseptinAineet;
    private ReseptiLista reseptiLista; 
    

    public ReseptiLisaaja(JTextField nimi, JTextArea aineet, ReseptiLista reseptilista){
         this.nimi = nimi;
         this.aineet = aineet;
         this.reseptinAineet = new ArrayList<>();
         this.reseptiLista = reseptilista;
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        String reseptinNimi = this.nimi.getText();
        
        String rivit[] = aineet.getText().split ("\n");
       
        ArrayList<String> listaAineenKomponenteista = new ArrayList<>(9);
        
        for (String rivi : rivit){
            String sanat[] = rivi.split(" ");
            listaAineenKomponenteista.addAll(Arrays.asList(sanat));
        }
       
        
        if(listaAineenKomponenteista.size()%3 != 0){
            ikkunaAvaaja = new IkkunaAvaaja ("\nAntamassasi reseptissä on virhe. \n Tarkistathan, että kaikki välit ovat paikoillaan \n ja kaikille aineille on määritelty oikeat määrät.\n");
            ikkunaAvaaja.run();
            return;
        }
        
        int i = 0;
        
        while (i < listaAineenKomponenteista.size()-2){
            String aine = listaAineenKomponenteista.get(i);
            i ++;
            int maara;
            
            try{
                maara = Integer.parseInt(listaAineenKomponenteista.get(i));
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
        
        boolean tapahtuiko = this.reseptiLista.lisaaResepti(reseptinNimi, reseptinAineet);
        
        if (tapahtuiko == false){ 
            this.ikkunaAvaaja = new IkkunaAvaaja (" Saman niminen resepti on jo olemassa \n nimeä resepti uudestaan. ");
        }
        else{
            this.ikkunaAvaaja = new IkkunaAvaaja(" Lisätty resepti näyttää tältä. \n Tarkistathan, että kaikki on oikein \n\n\n" + this.reseptiLista.etsiResepti(reseptinNimi));
            this.ikkunaAvaaja.run();
        }
        
    }
   
    
    
    
    
    
}

