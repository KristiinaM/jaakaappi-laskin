

package jaakaappilaskin.sovelluslogiikka;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka on Kaappi, johon ruokia laitetaan ja josta ne poistetaan sekö josta 
 * olemassa olev at ruoat saadaan näkymään. 
 * 
 */

public class Jaakaappi{
    
    private ArrayList<Ruoka> jaakaappi;
    
    /**
     * Jääkaappi-luokan konstruktori, mitään parametrejä ei ole. 
     * Konstruktori muodostaa uuden ArrayList tyyppisen jääkaappin.
     */
    
    public Jaakaappi(){
        this.jaakaappi = new ArrayList<>();
    }
    
    /**
     * Ruoan lisääminen jääkaappiin. 
     * 
     * @param ruoka, jääkaappiin lisättävä ruoka 
     */
    
    public void lisaaRuoka(Ruoka ruoka){
        this.jaakaappi.add(ruoka);
    }
    
    /**
     * Ruoan poistaminen jääkaapista. Metodi vertaa jääkaapissa olevia ruokia
     * parametrinä annettuun ja mikäli oikeaa ruokaa ei löydy, kertoo asiasta.
     * Jos oikean nimisiä ruokia on enemmän kuin yksi metodi poistaa sen, joka 
     * menee ensin vanhaksi. Jos ruoka esiintyy vain kerran, se poistetaan.
     * 
     * @param ruoka, nopeimmiten pilaantuva tietty ruoka joka poistetaan jääkaapista.  
     */
    
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
    
    /**
     * Tulostaa jääkaapissa olevat ruoat muotoon jokaisen ruoan nimi ja säilyvyys
     * omalle rivilleen.
     */
    
    public void tulosta(){
        this.jarjesta();
        for (Ruoka ruoka : jaakaappi){
            System.out.println(ruoka.getNimi() + " säilyy " + ruoka.getSailyvyys() + " päivää");
        }   
        
    }
    
    /**
     * Muuttaa jääkaapin sisällön string-tyyppiseksi muuttujaksi ja palauttaa sen.
     * String muuttuja on mallia ruoka + säilyvyys + väli + seuraava ruoka + säilyvyys....
     * 
     * @return Jääkaapin sisältö String-muodossa 
     */
    
    public String toString(){
        String string = "";
        for (Ruoka ruoka : jaakaappi){
            string = string + ruoka.getNimi()+ " ";
        }
        return string;
    }
    
    /**
     * Järjestää jääkaapissa olevat ruoat nimen mukaan aakkosjärjestykseen.
     */
    
    public void jarjesta(){
        Collections.sort(jaakaappi);
    }
            
    
}
