# Toteutusdokumentti


Alla ohjelman luokka- ja pakkauskaavio. Kaavion ulkopuolelle on jätetty testaamiseen liittyvä pakkaus "testaus", sillä sitä käytetään ainoastaan tehokkuustestaamiseen.

![](https://raw.githubusercontent.com/tuomoart/regex-tulkki/master/Dokumentaatio/Misc/Luokka-%20ja%20pakkauskaavio.png)

Ohjelmassa on siis erittäin kevyt tekstikäyttöliittymä, joka käyttää luokkaa Translator tekstisyötteiden ja säännöllisten lausekkeiden vertaamiseen. Translator tarjoaa julkisen metodin "matches" joka saa syötteenä tekstisyötteen ja lausekkeen ja palauttaa tiedon siitä, kuuluuko tekstisyöte annetun säännöllisen lausekkeen kuvaamaan kieleen.

Luokka Translator käyttää kahta tietorakennetta, Lista ja Merkkijono. Näiden nimet kertonevat tarpeeksi niiden tarkoituksista. Lista on toteutukseltaan suppea, ja se sisältää vain välttämättömät toiminnot. Se pohjautuu taulukkoon, jonka koko kaksinkertaistetaan aina kun se tulee täyteen. Samalla logiikalla toimii luokka Merkkijono, mutta se sisältää hieman enemmän ominaisuuksia.

Ohjelman käyttöohje löytyy [täältä](https://github.com/tuomoart/regex-tulkki/blob/master/Dokumentaatio/K%C3%A4ytt%C3%B6ohje.md)


## Aikavaativuus

Aikavaativuuden täsmällinen määritys ei onnistunut, mutta seuraavanlaisia havaintoja siitä selvisi:

Syötteen pituuden osalta pahin mahdollinen tapaus on se, jossa jokainen merkki muodostuu yhden toistettavan lauseen seurauksena, kuten [tehokkuustestauksen](https://github.com/tuomoart/regex-tulkki/blob/master/Dokumentaatio/Testausdokumentti.md) esimerkkilausekkeissa. Tällöin ohjelma joutuu käymään läpi kaikki toistomäärät nollasta syötteen pituuteen n. Tämä aiheuttaa rekursiivisen tarkasta-metodin suorituskertoja O(n²) kappaletta. Jos toistettava lauseke on esimerkiksi (a|b|c), eli se sisältää kolme vaihtoehtoa, seuraa jokaisesta n² tarkasta-metodin suorituksesta vielä vaihtoehtojen verran suorituksia, siis yhteensä O(mn²), missä m on vaihtoehtojen määrä.

En ole onnistunut keksimään tätä vaikeampia tapauksia. Koska algoritmi ei käy kaikkia mahdollisia lausekkeen kuvaamia merkkijonoja loppuun asti ennen kuin se tarkastaa, tääsmääkö joku niistä syötteeseen, vaan se tarkastaa syötemerkkijonoa merkki kerrallaan, rajautuu suurin osa lausekkeen kuvaamaan kieleen kuuluvista merkkijonoista pois tarkastelusta.


## Tehokkuus ja testaus

Tehokkuutta ja yksikkötestausta on tutkittu tarkemmin [testausdokumentissa](https://github.com/tuomoart/regex-tulkki/blob/master/Dokumentaatio/Testausdokumentti.md). Siinä on myös verrattu oman toteutuksen suorituskykyä Javan valmiiseen toteutukseen sekä analysoitu tulosten syitä.


## Kehityskohteet

Ohjelmaa olisi voinut kehittää eteenpäin ainakin seuraavilla tavoilla:

 - Lyhennysmerkintöjen tuki. Valtaosan lyhennysmerkinnöistä voisi tehdä tuetuksi syntaksinmuokkauksen kautta. Toisinsanoen jos annettu lauseke käyttää lyhennysmerkintöjä, avattaisiin nämä merkinnät ensin käyttämään tunnistusalgoritmin tuntemia perusoperaatioita ja vasta sitten annettaisiin tämä avattu lauseke tarkastettavaksi. Siis itse tarkastajan ei tarvitse, eikä todennäköisesti kannatakaan tukea kaikkia mahdollisia merkintätapoja.
 - Virheellisten syötteiden tutki
 - Erityismerkkien käyttö osana merkistöä, siis että esimerkiksi |-merkki voisi olla osa syötemerkkijono
 - Merkkijono ja Lista -tietorakenteet olisi voinut toteuttaa yhden luokan pohjalle, mutta tähän ei enää ollut aikaa
 - Nimeämiskäytännöt voisivat olla yhteneväisempiä, samaten käytetty kieli. Lista-rakenne noudattaa ArrayList-luokan nimentää ja on englanniksi, sillä Lista korvasi sen lähes suoraan.
 - Translator-luokan metodi on turhan pitkä. Toisaalta sen pätkiminen voisi tehdä ohjelmasta vaikeaselkoisemman.
 - Merkkijono-olioita kloonataan eri vaihtoehtojen kokeilemisen mahdollistamiseksi. Nykyinen tapa kloonata ei välttämättä ole optimaalinen ja toisaalta on mahdollista, että koko kloonaamiselta olisi voinut välttyä. Tätä olisi ajan salliessa voinut tutkia enemmän.


## Tekijältä

Toimivaan ratkaisuun pääseminen oli yllättävän vaikeaa ja toimiva lopullinen algoritmi syntyikin vasta viimeisellä viikolla. Alusta joutui aloittamaan kolme kertaa. Lopputuloksena syntynyt algoritmi ja sitä kautta koko harjoitustyö on sen verran yksinkertainen, että hirvittää, riittääkö se laajuudeltaan. Toisaalta, kuten ohjaaja (Hannu) projektin alussa sanoi, tähän ei tarvita laajaa implementaatiota, sillä mallia tulkille ei löydy, toisin kun regex-kääntäjään. Jos aika olisi riittänyt, olisin halunnut vielä lisätä ainakin yhden lyhennysmerkinnän tuen proof-of-concept -tarkoituksella.
