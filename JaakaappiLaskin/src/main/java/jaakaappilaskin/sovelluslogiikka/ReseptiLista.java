
package jaakaappilaskin.sovelluslogiikka;


import java.util.ArrayList;

/**
 * Luokka jonka mukaisena resepteistä säilytetään listaa
 * 
 */

public class ReseptiLista{
    
    private ArrayList<Resepti> reseptiLista;

    /**
     * Reseptilistan konstruktori, luo uuden reseptilista ArrayListin. 
     */
    
    public ReseptiLista() {
        this.reseptiLista = new ArrayList<>();
    }
    
    /**
     * Lisää uuden reseptin
     * @param nimi reseptin nimi
     * @param aineet reseptiin kuuluvien aineiden lista
     * @return boolean saatiinko resepti lisättyä
     */    
    
    public boolean lisaaResepti(String nimi, ArrayList<Ainesosa> aineet){
        
        for (Resepti resepti : reseptiLista){
            if (resepti.getNimi().equalsIgnoreCase(nimi)){
                return false;
            }
        }
        
        Resepti resepti = new Resepti(nimi, aineet);
        reseptiLista.add(resepti);
        return true;
    }
    
    /**
     * Reseptin etsiminen reseptin nimen perusteella. Jos reseptiä ei löydy,
     * palautetaan asiasta kertova teksi.
     * 
     * @param nimi, minkä nimistä reseptiä etsitään
     * @return nimeen liittyvä resepti tai reseptiä ei löydy -teksti
     * 
     */
    
    public String etsiResepti(String nimi){
        for (Resepti resepti : reseptiLista){
            if (resepti.getNimi().equalsIgnoreCase(nimi)){
                return resepti.toString();
            }
        }
        return "Reseptiä ei löytynyt";
    }
    
    /**
     * Etsitään jotain olemassaolevaa reseptiä, joka sisältää tietyn aineen.
     * Mikäli useassa reseptissä käytetään samaa ainetta, palautetaan ne kaikki.
     * 
     * @param nimi, resepteistä etsittävän aineen nimi
     * @return reseptit, joissa ainetta käytetään
     */
    
    
    public String reseptiAineelle(String nimi){
        
        String palautettava = "";
        
        for (Resepti resepti : reseptiLista){
            ArrayList<Ainesosa> aineet = resepti.haeAineet();
            
            for (Ainesosa aine: aineet){
                if(aine.getNimi().equalsIgnoreCase(nimi)){
                    palautettava += resepti.toString()+ "\n";
                }
            }
        }
        if (palautettava.length()<=0){
            return "Reseptiä ei löytynyt";
        }
        else{
            return palautettava;
        }
        
    } 
    
    /**
     * Poistetaan jokin olemassa oleva resepti.
     * @param nimi poistettavan reseptin nimi
     * @return boolean saatiinko poistettua
     */
    
    
      public boolean poistaResepti(String nimi){
          
          for (Resepti resepti : this.reseptiLista){
              if(resepti.getNimi().equalsIgnoreCase(nimi)){
                  reseptiLista.remove(resepti);
                  return true;
              }
          }
          
        return false;
      }
    
    
}
