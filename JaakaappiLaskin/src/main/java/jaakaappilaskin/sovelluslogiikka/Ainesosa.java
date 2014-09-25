
package jaakaappilaskin.sovelluslogiikka;

/*
    * Ainesosa on resepteissa kaytettava aine, joka tarjoaa mahdollisuuden 
    *tarvittavan maaran dokumentointiin
    */

public class Ainesosa {
    
    private String ruoanNimi;
    private int kokonaisLukuMaara = 0;
    private double decimaaliMaara =0.0;
    private String maaranMitta;

 /*
    * Ainesosan konstruktori, jolle syatetaan kyseisen ruoka-aineen nimi,
    * kaytettava maara ja mittayksikko.
    * @ param ruoanNimi, maara ja maaranMitta Reseptin kautta tuleva syote
    */   
    
    public Ainesosa(String ruoanNimi, int maara, String maaranMitta){
       this.ruoanNimi = ruoanNimi;
       this.kokonaisLukuMaara= maara;
       this.maaranMitta = maaranMitta;
    }
    
/*
    * Vaihtoehtoinen konstruktori, jos maara on decimaaliluku
    *
    *@ param ruoanNimi, maara desimaalina, ja maaranMitta
    */    
    
    public Ainesosa (String ruoanNimi, double maara, String maaranMitta){
        this.ruoanNimi = ruoanNimi;
        this.decimaaliMaara = maara;
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
/*
    * Palauttaa ainesosan määrän ja määrän mittayksikön String-muodossa
    *
    * @return ainesosan määrä + mittayksikkö 
    */    
    
    
    public String getMaara(){
        String haettava = "";
        
        if (this.decimaaliMaara <= 0.0){
            haettava = this.kokonaisLukuMaara + " " +  this.maaranMitta;
            }
        if (this.kokonaisLukuMaara <= 0){
            haettava = this.decimaaliMaara + " " + this.maaranMitta;
        }
            return haettava;
    }
    
/*
    * Palautttaa ainesosan määrineen String muodossa
    * 
    * @return ainesosan nimi + määrä + mittayksikkö
    */    
    
    public String toString(){
        return this.ruoanNimi + " " + this.getMaara();
    }
    
}
