
package jaakaappilaskin.sovelluslogiikka;


import java.util.ArrayList;

/**
 * Luokka sisältää reseptin rakenteen, eli resptin nimen ja ainesosien listan. 
 * 
 */

public class Resepti{
    
    private String nimi;
    private ArrayList<Ainesosa> ainesosat;
    
    
    /**
     * Resepti-luokan konstruktori. 
     * 
     * @param nimi, reseptin nimi
     * @param ainesosat, reseptiin tarvittavien ainesosien lista 
     */
    
   public Resepti(String nimi, ArrayList<Ainesosa> ainesosat){
       this.nimi = nimi;
       this.ainesosat = ainesosat;
    }
   
    /**
     * Palauttaa tiettyyn reseptiin liittyvät ainesosat listana.
     * @return reseptiin tarvittava lista aineista
     */
   
    public ArrayList<Ainesosa> haeAineet(){
        return this.ainesosat;
    }
    
    /**
     * Hakee reseptin nimen
     * @return reseptin nimi
     */
    
    public String getNimi(){
        return this.nimi;
    }
    
    /**
     * Muuttaa reseptin String muotoiseksi, nimi yhdellä rivillä jokainen
     * ainesosa määrineen omallaan.
     * 
     * @return resepti String-muodossa 
     */
    
    public String toString(){
        String resepti = this.nimi + "\n";
        for (Ainesosa aine : ainesosat){
            resepti += aine.toString() + "\n";
        }
        return resepti;
    }
    
    /**
     * Lisää parametrina annetun ainesosan reseptiin
     * @param ainesosa, reseptiin lisättävä ainesosa 
     */
    
    public void lisaaAinesosa(Ainesosa ainesosa){
        this.ainesosat.add(ainesosa);
    }
            
}
