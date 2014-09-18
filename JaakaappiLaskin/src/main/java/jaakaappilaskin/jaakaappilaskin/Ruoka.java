

package jaakaappilaskin.jaakaappilaskin;


public class Ruoka {
    
    private String nimi;
    private int sailyy;
    
    public Ruoka(String nimi){
        this.nimi = nimi;
        this.sailyy = 5;
    }
    
    public Ruoka(String nimi, int sailyy){
        this.nimi = nimi;
        this.sailyy = sailyy;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public String toString(){
        return this.nimi;
    }
    
    public void paivaVaihtuu(){
        this.sailyy --;
    }
    
    public int getIka(){
        return this.sailyy;
    }
    
    
    

            
            
}
