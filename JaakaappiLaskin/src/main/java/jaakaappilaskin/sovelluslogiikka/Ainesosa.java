
package jaakaappilaskin.sovelluslogiikka;

/*
* Ainesosa on resepteissä käytettävä aine, joka tarjoaa mahdollisuuden 
*tarvittavan määrän dokumentointiin
*/

public class Ainesosa {
    
    private String ruoanNimi;
    private int maara;
    private String maaranMitta;

 /*
 * Ainesosan konstruktori, jolle syötetään kyseisen ruoka-aineen nimi,
 * käytettävä määrä ja mittayksikkö.
 * @param ruoanNimi, maara ja maaranMitta Reseptin kautta tuleva ryöte
 */   
    
    public Ainesosa(String ruoanNimi, int maara, String maaranMitta){
       this.ruoanNimi = ruoanNimi;
       this.maara = maara;
       this.maaranMitta = maaranMitta;
    }
    
/*
* Palauttaa ainesosan nimen.
*
* @return ainesosan nimi    
*/    
    
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
