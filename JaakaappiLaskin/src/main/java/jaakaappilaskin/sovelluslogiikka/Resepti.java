
package jaakaappilaskin.sovelluslogiikka;

import java.util.ArrayList;


public class Resepti {
    
    private String nimi;
    private ArrayList<Ainesosa> ainesosat;
    
    
   public Resepti(String nimi, ArrayList<Ainesosa> ainesosat){
       this.nimi = nimi;
       this.ainesosat = ainesosat;
    }
   
    public ArrayList<Ainesosa> haeAineet(){
        return this.ainesosat;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public String toString(){
        String resepti = this.nimi + "\n";
        for (Ainesosa aine : ainesosat){
            resepti += aine.toString() + "\n";
        }
        return resepti;
    }
    
    public void lisaaAinesosa(Ainesosa ainesosa){
        this.ainesosat.add(ainesosa);
    }
            
}
