

package jaakaappilaskin.sovelluslogiikka;


/**
 * 
 * Luokka kuvaa jääkaapissa säilytettävää asiaa, eli erilaisia ruokia. 
 * 
 */


public class Ruoka implements Comparable<Ruoka>{
    
    
    private String nimi;
    private int sailyy;
   
    /**
     * Ruoan konstruktori, jossa parametrina ruoan nimi. Konstruktori asettaa
     * ruoan säilymisajaksi oletuksena 5 päivää.
     * 
     * @param nimi, ruoan nimi
     */
    
    
    public Ruoka(String nimi){
        this.nimi = nimi;
        this.sailyy = 5;
    }
    
    /**
     * Ruoan vaihtoehtoinen konstruktori, jossa parametrina ruaon nimi ja sen
     * säilymisaika. Nämä asetetaan muuttujiin.
     * 
     * @param nimi, ruoan nimi
     * @param sailyy, ruoan säilyvyys  
     */
    
    public Ruoka(String nimi, int sailyy){
        this.nimi = nimi;
        this.sailyy = sailyy;
    }
    
    /**
     * Palauttaa ruoan nimen
     * 
     * @return ruoan nimi
     */
    
    public String getNimi(){
        return this.nimi;
    }
    
    /**
     * Muuttaa ruoan String-tyyppiseksi muuttujaksi sisältäen ruoan nimen.
     * 
     * @return ruoan nimi string-muuttujana.
     */
    
    public String toString(){
        return this.nimi;
    }
    
    /**
     * Ruoan säilyvyys vähenee yhdellä. 
     */
    
    
    public void paivaVaihtuu(){
        this.sailyy --;
    }
    
    /**
     * palauttaa säilyvyyden int muuttujana. 
     * @return tietyn ruoan säilyvyys
     */
    
    public int getSailyvyys(){
        return this.sailyy;
    }
    
    /**
     * Ruokien järjestämissääntö, järejstäminen nimen mukaan
     * @param ruoka, ruoka jota käytetään järjestyksen vertailuun
     * @return järjestys
     */
    
    @Override
    public int compareTo(Ruoka ruoka) {
        return this.nimi.compareToIgnoreCase(ruoka.getNimi());
    }
    
}


            
            

