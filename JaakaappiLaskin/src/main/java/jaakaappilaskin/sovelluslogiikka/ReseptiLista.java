
package jaakaappilaskin.sovelluslogiikka;

import java.util.ArrayList;


public class ReseptiLista {
    
    private ArrayList<Resepti> reseptiLista;

    public ReseptiLista() {
        this.reseptiLista = new ArrayList<>();
    }
    
    public void lisaaResepti(String nimi, ArrayList<Ainesosa> aineet){
        Resepti resepti = new Resepti(nimi, aineet);
        reseptiLista.add(resepti);
    }
    
    public String etsiResepti(String nimi){
        for (Resepti resepti : reseptiLista){
            if (resepti.getNimi().equals(nimi)){
                return resepti.toString();
            }
        }
        return "Reseptiä ei löytynyt";
    }
    
    public String reseptiAineelle(String nimi){
        
        String palautettava = "";
        
        for (Resepti resepti : reseptiLista){
            ArrayList<Ainesosa> aineet = resepti.haeAineet();
            
            for (Ainesosa aine: aineet){
                if(aine.getNimi().equals(nimi)){
                    palautettava += resepti.toString()+ "\n";
                }
            }
        }
        if (palautettava.length()<1){
            return "Reseptiä ei löytynyt";
        }
        else{
            return palautettava;
        }
    }
}
