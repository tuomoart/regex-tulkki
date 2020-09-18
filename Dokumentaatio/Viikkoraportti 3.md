Tällä viikolla sain Zoom-tapaamisen ansiosta jo melko hyvin kiinni siitä, mitä tulee tehdä. Ohjelmaa on nyt muokattu siten, että se toteuttaa aiemmat toiminnallisuudet rekursiivista mallia käyttäen, minkä lisäksi siihen on lisätty + -operaattorin tuki.

Seuraavana toteutan ohjelmaan sulkujen ja tai- operaation tuen. Tämä tulee todennäköisesti vaatimaan aika suuria muutoksia ohjelmaan, jotta sen saa toimimaan edes jossain määrin järkevästi. En ole tällä hetkellä muutenkaan tyytyväinen koodin laatuun ja olen varma, että nykyisetkin toiminnallisuudet voi toteuttaa huomattavasti pienemmällä määrällä koodia. Olen kuitenkin nyt priorisoinut määrän laadun yli. Koodia ei ole kommentoitu kunnolla, muuta kuin julkisten metodien javadoc:ien osalta. Ohjelmalogiikka muuttuu jatkuvasti niin paljon, ettei kattavan kommentoinnin ylläpitäminen kannata kun projektia työstää yksi ihminen säännöllisen tiheästi. Jossain vaiheessa aion lisätä ohjelmaan sellaisen komentorivikäyttöliittymän, että syötteet ja lausekkeet voi antaa suoraan komentoriviltä. Nyt kehitysvaiheessa tämä ei kuitenkaan ole tarvittavaa tai oikeastaan edes toivottua, joten jätän käyttöliittymän viimeiseksi. Sen tekeminen onnistuu nopeasti.

Ohjelma on nyt rakenteeltaan sellainen, että sitä on helppo testata. Sen lisäksi aihe on helposti testattava, ja siis testaus onkin melkoisen kattavaa. Ihan jokaista rajaskenaariota en ole testannut, mutta olen kirjoittanut jokaiselle toiminnallisuudelle sellaiset testit, että logiikkaa voi huoletta muokata ja testit huolehtivat, että se säilyy pääosin toimivana. Alla testikattavuusraportti:

![](https://raw.githubusercontent.com/tuomoart/regex-tulkki/master/Dokumentaatio/Misc/Testikattavuus.png)

Haarautumakattavuuden muutama puuttuva prosentti johtuvat sellaisista rajatapauksista, joille en äkkiä keksinyt hyvää testiä. Tarkoituksenani on saada lopulliseen työhön aidosti kaikenkattava testaus.

Checkstylen mukaan tarkastettu koodin formaatti kuntoon.
