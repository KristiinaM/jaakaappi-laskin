**Testausdokumentaatio**

Järjestelmän käyttöliittymää on testattu käsin, eikä yksikkötesteillä. Testausta on tehty seuraavasti:

* Kokeiltu oikeanlaisten arvojen syöttämistä ja todettu kaikki ominaisuudet toimiviksi. 
* kokeiltu erilaisten tietojen poistamista, listaamista ja hakemista, ja todettu ominaisuudet toimiviksi.
* Kokeiltu syöttää virheellisiä arvoja, esimerkiksi säilyvyyteen muuta kuin numeroita ja että reseptin 
ainesosat pitää olla laitettuna oikeaan muotoon. 

Testauksen yhteydessä havaittiin, että useat käyttöliittymäluokat eivät alunperin toimineet odotusten mukaisesti, 
vaikka niitä vastaava yksikkötestaus suoraan sovelluslogiikasta toimikin aivan hyvin. Näitä korjailtiin useaan otteeseen 
käyttöliittymän edetessä. 

Käyttöliittymän lisäksi main-luokkaa ei ole testattu, koska sillä ei ole muuta toiminnallisuutta kuin avata ohjelma,
jonka se tekee onnistuneesti.

 

