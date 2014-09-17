

package jaakaappilaskin.jaakaappilaskin;


public class Ruoka {
    
    private String nimi;
    private int ika;
    private int sailyy;
    
    public Ruoka(String nimi){
        this.nimi = nimi;
        this.ika = 1;
        this.sailyy = 5;
    }
    
    public Ruoka(String nimi, int sailyy){
        this.nimi = nimi;
        this.ika = 1;
        this.sailyy = sailyy;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public String toString(){
        return this.nimi;
    }
    
    public void paivaVaihtuu(){
        this.ika ++;
        this.sailyy --;
    }
    
    
    

            
            
}
