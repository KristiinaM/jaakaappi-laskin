
package jaakaappilaskin.jaakaappilaskin;


public class Ainesosa {
    
    private String ruoanNimi;
    private int maara;
    private String maaranMitta;
    
    public Ainesosa(String ruoanNimi, int maara, String maaranMitta){
       this.ruoanNimi = ruoanNimi;
       this.maara = maara;
       this.maaranMitta = maaranMitta;
    }
    
    public String getNimi(){
        return this.ruoanNimi;
    }
    
    public String getMaara(){
        String haettava = this.maara + " " +  this.maaranMitta;
        return haettava;
    }
    
    public String toString(){
        return this.ruoanNimi + " " + this.getMaara();
    }
    
}
