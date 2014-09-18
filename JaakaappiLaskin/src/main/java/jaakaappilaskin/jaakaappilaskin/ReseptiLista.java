
package jaakaappilaskin.jaakaappilaskin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class ReseptiLista {
    
    private HashMap <String, ArrayList<Ruoka>> reseptiLista;

    public ReseptiLista() {
        this.reseptiLista = new HashMap <>();
    }
    
    public void lisaaResepti(String nimi, ArrayList<Ruoka> aineet){
        this.reseptiLista.put(nimi, aineet);
    }
    
    public ArrayList<Ruoka> etsiResepti(String nimi){
        return this.reseptiLista.get(nimi);
    }
    
    public Set ruokaVaihtoehdot(){
        return this.reseptiLista.keySet();
    }
}
