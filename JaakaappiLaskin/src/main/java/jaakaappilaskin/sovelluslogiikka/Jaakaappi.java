

package jaakaappilaskin.sovelluslogiikka;

import java.util.ArrayList;
import java.util.Collections;

public class Jaakaappi{
    
    private ArrayList<Ruoka> jaakaappi;
    
    public Jaakaappi(){
        this.jaakaappi = new ArrayList<Ruoka>();
    }
    
    public void lisaaRuoka(Ruoka ruoka){
        this.jaakaappi.add(ruoka);
    }
    
    public void poistaRuoka(Ruoka ruoka){
        int i = 0;
        int sijainti = 0;
        int sailyvyys = 1000;
        int pilaantuvinSijainti = 0;
        
        for (Ruoka kaapinsisus: jaakaappi){
            if (kaapinsisus.getNimi().equals(ruoka.getNimi())){
                if (kaapinsisus.getSailyvyys()< sailyvyys){
                    pilaantuvinSijainti = sijainti;
                }
                i ++;
            }
            sijainti ++;
        }
        
        if (i == 0){
            System.out.print("Ruokaa ei löytynyt");
        }
        if (i == 1){
            this.jaakaappi.remove(ruoka);
        }
        if (i > 1){
            this.jaakaappi.remove(pilaantuvinSijainti);
        }
    }
    
    public void tulosta(){
        this.jarjesta();
        for (Ruoka ruoka : jaakaappi){
            System.out.println(ruoka.getNimi() + " säilyy " + ruoka.getSailyvyys() + " päivää");
        }   
        
    }
    
    public String toString(){
        String string = "";
        for (Ruoka ruoka : jaakaappi){
            string = string + ruoka.getNimi()+ " ";
        }
        return string;
    }
    
    public void jarjesta(){
        Collections.sort(jaakaappi);
    }
            
    
}
