
package jaakaappilaskin.sovelluslogiikka;

import jaakaappilaskin.kayttoliittyma.Kayttoliittyma;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args){
    
        Jaakaappi jaakaappi = new Jaakaappi();
        ReseptiLista reseptiLista = new ReseptiLista();
        
        try {
            FileInputStream fin = new FileInputStream("reseptiLista.dat");
            ObjectInputStream ois = new ObjectInputStream(fin);
            reseptiLista = (ReseptiLista) ois.readObject();
            ois.close();
        }
         catch (Exception e) { e.printStackTrace(); }
        
   
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(jaakaappi, reseptiLista);
        SwingUtilities.invokeLater(kayttoliittyma);

        try {
            FileOutputStream fout = new FileOutputStream("resepliLista.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(reseptiLista);
            oos.close();
        }
        catch (Exception ex) {
            ex.printStackTrace(); 
        }
    }   
    
        
    

}
    
    
    
    

