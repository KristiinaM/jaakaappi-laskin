

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
        this.jaakaappi.remove(ruoka);
    }
    
    public void tulosta(){
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
