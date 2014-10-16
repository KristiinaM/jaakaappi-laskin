**Aihe:** 

Jääkaappilaskin. Toteutetaan järjestelmä, jonka avulla pidetään kirjaa siitä, mitä jääkaapista löytyy. Takoitus on, että järjestelmään lisätään tieto ostetuista ruoista 
ja niiden parasta ennen päivämääristä ja ohjelma kertoo jatkossa mitä jääkaapissa on ja kuinka kauan ne säilyvät. Järjestelmään voi myös lisätä ruokaohjeita ja hakea tai poistaa niitä. 

Järjestelmä on valmis päivitettäväksi seuraavien ominaisuuksien osalta, jotka eivät valitettavasti ole osa tätä versiota: 
* Tiedostoon kirjoittaminem, jotta tiedot säilyvät myös järjestelmän ollessa poissa päältä.
* Kalenteriominaisuus tai tapa mitata kuinka kauan edellisestä käyttölkerrasta on jotta järjestelmä tietää, milloin mikäkin ruoka menee vanhaksi
* Vanhaksi menneiden ruokien listaaminen 
* Reseptiin tarvittavien ainesosien vertaaminen olemaasaoleviin ruokiin


Käyttäjien toiminnot on listattu alla rakennekuvauksessa, sillä toiminnot vastaavat täysin käyttöliittymän luokkien rakennetta. 



**Rakennekuvaus**


*Käyttäjät*
Käyttöjärjestelmä jonka kautta seuraavat toiminnot tapahtuvat:

*Käyttäjien toiminnot/käyttöliittymään liittyvät luokat*:
* jääkaappiin lisääminen, lisää jääkaappiin Jaakaappiluokan kautta 
* jääkaapinsta poistaminen, poistaa jääkaapista Jaakaappi-luokan kautta
* jääkaapin sisällön listaaminen, listaa sisällön Jaakaappi-luokan kautta
* ruokaohjeen etsiminen ohjeen nimen perusteella, hakee reseptiä ReseptiListan kautta
* ruokaohjeen etsiminen ohjeessa esiintyvän ainesosan perusteella, hakee reseptiä reseptiListan kautta
* ruokaohjeen lisääminen järjestelmääm, lisää reseptin Reseptilistan kautta
* ruokaohjeen poistaminen järjestelmästä, poistaa Reseptin Reseptilistan kautta

* Lisäksi käyttöjärjestelmässä on IkkunaAvaaja, joka avaa uusia ikkunoita aina, kun käyttöjärjestelmä palauttaa tietoa käyttäjälle.   


*Jaakaappi*
* Jaakaappi-luokka hallinnoi jääkaapin sisältöä, sen kautta lisätään, poistetaan ja listataan ruokia. 
* Jaakaappiin sisältyy luokka ruoka, joka pitää siällään ruoan ominaisiidet (nimen ja säilymisen).


*ReseptiLista*
* Reseptilistan kautta hallinnoidaan olemassa olevia reseptejä. Reseptejä lisätään, poistetaan ja etsitään. 
* Reseptilistaan siältyy luokka resepti, joka muotoisia jokainen resepti on. Reseptillä on nimi ja ainesosalista. 
* Myös Ainesosa-luokka liittyy resepteihin, sillä jokaisen reseptin ainesosalista muodostuu Ainesosa-olioista,
joilla jokaisella on nimi, määrä ja mittayksikkö.  

 


